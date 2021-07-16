<template>
  <div style="width: 100%">
  <el-table
      :data="tableData"
      border
      style="width: 100%">
    <el-table-column
        fixed
        prop="id"
        label="编号"
        width="150">
    </el-table-column>
    <el-table-column
        prop="name"
        label="书名"
        width="600">
    </el-table-column>
    <el-table-column
        prop="author"
        label="作者"
        width="350">
    </el-table-column>
    <el-table-column
        fixed="right"
        label="操作"
        width="200">
      <template slot-scope="scope">
        <el-button @click="handleClick(scope.row)" type="text" size="small">修改</el-button>
        <el-button @click="deleteBook(scope.row)" type="text" size="small">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

    <el-pagination
        background
        layout="prev, pager, next"
        page-size="10"
        :total="this.total"
        @current-change="page">
    </el-pagination>

  </div>
</template>


<script>
export default {
  methods: {
    deleteBook(row){
      this.$axios.delete('http://localhost:8181/book/deleteById/'+row.id).then(resp => {
        this.$message('删除成功！');
        window.location.reload();
      })
    },
    handleClick(row) {
      this.$router.push({
        path:'/update',
        query:{
          id:row.id
        }
      })
    },
    page(currentPage){
      this.$axios.get('http://localhost:8181/book/findAll/'+currentPage+'/10').then(resp => {
        this.tableData = resp.data.content;
        this.total=resp.data.totalElements
      })
    }
  },
  created(){
    this.$axios.get('http://localhost:8181/book/findAll/1/10').then(resp => {
      this.tableData = resp.data.content;
      this.total=resp.data.totalElements
    })
  },

  data() {
    return {
      tableData: null,
      total:null
    }
  }
}
</script>