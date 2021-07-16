<template>
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

    <el-form-item label="图书编号" prop="name">
      <el-input v-model="ruleForm.id" readonly style="width: 60%"></el-input>
    </el-form-item>

    <el-form-item label="图书名称" prop="name">
      <el-input v-model="ruleForm.name" style="width: 60%"></el-input>
    </el-form-item>

    <el-form-item label="作者" prop="author">
      <el-input v-model="ruleForm.author" style="width: 60%"></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>

</template>

<script>
export default {
  name:'BookUpdate',
  data() {
    return {
      ruleForm: {
        id:'',
        name: '',
        author: '',
      },
      rules: {
        name: [
          {required: true, message: '图书名不能为空', trigger: 'blur'},
        ],
        author:[
          {required: true, message: '作者不能为空', trigger: 'blur'},
        ],
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$axios.put('http://localhost:8181/book/update',this.ruleForm).then(resp => {
            if(resp.data =='success'){
              this.$message('修改成功！');
              this.$router.push('/BookManage')
            }
          })
        } else {
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
  created() {

      this.$axios.get('http://localhost:8181/book/findById/'+this.$route.query.id).then(resp =>{
          this.ruleForm=resp.data;
      } )
  }
}
</script>

<style>

</style>