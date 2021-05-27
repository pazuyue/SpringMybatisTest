<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <!-- import CSS -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/currency.css">
</head>
<body>

<div id="app">
    <el-container>
        <el-header style="text-align: right; font-size: 12px">
            <span>月光新闻发布系统</span>
        </el-header>
        <el-main>
            <el-row>
                <el-col :gutter="24">
                    <el-form id="ruleForm" :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" action="${pageContext.request.contextPath}/login"  method="post">
                        <el-form-item label="名称" prop="loginName">
                            <el-input v-model="ruleForm.loginName" name="loginName"></el-input>
                        </el-form-item>
                        <el-form-item label="密码" prop="password">
                            <el-input type="password" v-model="ruleForm.password" name="password" autocomplete="off"></el-input>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                            <el-button @click="resetForm('ruleForm')">重置</el-button>
                        </el-form-item>
                    </el-form>
                </el-col>
            </el-row>
        </el-main>
        <el-footer></el-footer>
    </el-container>


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
                    password: '',
                },
                errorMsg:"${msg}",
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
        mounted: function () {
            if (this.errorMsg!=''){
                this.$message.error(this.errorMsg);
            }
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    console.log('validate'+valid);
                    if (valid) {
                        console.log('submit!'+this.ruleForm.loginName);
                        console.log('submit!'+this.ruleForm.password);
                        $("#ruleForm").trigger("submit")
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
        }
    })

</script>
</html>

