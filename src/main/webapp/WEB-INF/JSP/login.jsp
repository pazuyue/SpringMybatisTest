<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <!-- import CSS -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
</head>
<body>
${msg}
<div id="app">
    <el-row>
        <el-col :span="24">
            <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                <el-form-item label="名称" prop="loginName">
                    <el-input v-model="ruleForm.loginName"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                    <el-button @click="resetForm('ruleForm')">重置</el-button>
                </el-form-item>
            </el-form>
        </el-col>
    </el-row>

</div>
</body>
<!-- import Vue before Element -->
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- import JavaScript -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/jquery-1.4.2.min.js"></script>
<script>

    new Vue({
        el: '#app',
        data: function() {
            var checkloginName = (rule, value, callback) => {
                if (value === '') {
                    return callback(new Error('用户名不能为空'));
                }
                callback()
            };
            var validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                }
                callback()
            };
            return {
                ruleForm: {
                    loginName: '',
                    password: ''

                },
                rules: {
                    loginName: [
                        { validator: checkloginName, trigger: 'blur' }
                    ],
                    password: [
                        { validator: validatePass, trigger: 'blur' }
                    ],

                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    console.log('validate'+valid);
                    if (valid) {
                        console.log('submit!'+this.ruleForm.loginName);
                        console.log('submit!'+this.ruleForm.password);
                        $.post("${pageContext.request.contextPath}/login",
                            {
                                loginName:this.ruleForm.loginName,
                                password:this.ruleForm.password
                            },
                            function(data,status){
                                console.log("数据：" + data + "\n状态：" + status);
                            });
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    })

</script>
</html>

