<template>
    <el-card shadow="never" style="margin-top: 10px;">
        <!-- 表格区域 -->
        <el-table :data="tableData" stripe>
            <el-table-column prop="id" label="ID" width="70" />
            <el-table-column prop="sqren" label="昵称" width="160" />
            <el-table-column prop="sqliyou" label="申请理由" width="280" />
            <el-table-column prop="shzhuangtai" label="审核状态" width="160">
              <!-- <template #default="scope">
                  {{ statusMap[scope.row.shzhuangtai] || '未知状态' }}
              </template> -->
          </el-table-column>
            <el-table-column prop="cttime" label="创建时间" width="280" />
            <el-table-column prop="mdtime" label="更新时间" width="280" />
            <!-- <el-table-column label="操作" width="120" fixed="right">
                <template #default="scope">
                    <el-dropdown @command="handleCommand" trigger="click" style="margin-top: .5vh;">
                        <button @click="er(scope.row)" style="color: #0066CC; cursor: pointer;"
                            v-if="!scope.row.status">取消申请</button>
                        <span class="status-reviewed" style="color: #909399;" v-if="!scope.row.status">待审核</span>
                        <button @click="er(scope.row)" style="color: #0066CC; cursor: pointer;"
                            v-else-if="scope.row.status == 1">下载</button>
                        <span class="status-reviewed" style="color: #909399;" v-else>未通过申请</span>
                    </el-dropdown>
                </template>
            </el-table-column> -->
        </el-table>
        <!-- 分页 -->
        <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange"
            layout="sizes, total, prev, pager, next" :total="totalNum" :currentPage="search.pageNum"
            :pageSize="search.pageSize">
        </el-pagination>
    </el-card>
</template>
  
<script>
import sDrawer from "@/components/s-drawer/s-drawer.vue"
export default {
    components: {
        sDrawer,
    },
    watch: {
        visible(value) {
            if (!value) {
                this.form = {}
            }
        }
    },
    data() {
        return {
            form: {},
            visible: false,
            tableData: [],
            totalNum: 0,
            search: {
                pageNum: 1,
                pageSize: 10,
                shenhezt: 2,
            },
            statusMap: {
                0: '待审核',
                1: '已通过',
                2: '未通过', // 根据您的实际状态码定义对应的中文描述
            },
        };
    },
    created() {
        this.getList();
    },
    methods: {
        async getList() {
            const res = await this.$request.get(
                "/jc/shenpi/",
                { params: this.search }
            );
            console.log(res.data)
            if (res.data.code === 200) {
                // 直接对筛选后并排序的数据赋值给 this.tableData
                this.tableData = res.data.data
                this.totalNum = res.data.zs
            }
        },
        // 每页条数改变时触发 选择一页显示多少行
        handleSizeChange(val) {
            console.log(`每页 ${val} 条`);
            this.search.pageSize = val;
            this.getList();
        },
        // 当前页改变时触发 跳转其他页
        handleCurrentChange(val) {
            console.log(`当前页: ${val}`);
            this.search.pageNum = val;
            this.getList();
        },
        resetSearch() {
            let search = {
                pageNum: this.search.pageNum,
                pageSize: this.search.pageSize,
            };
            this.search = search;
            this.getList();
        },
        editItem(row) {
            this.form = this.$deepClone(row)
            this.visible = true
        },
        async handleCommand(command) {
            this.form.status = Number(command)
            // const res = await this.$request.post('/api/video/admin/page_audit', this.form)
            // if (res.data.code === 200) {
            //   this.$message.success(res.data.message)
            //   this.getList()
            // }

        }
        ,// 正则文件名
        extractFilenameFromContentDisposition(contentDisposition) {
            const regex = /filename="?([^;\n"]*)"?/;
            const match = contentDisposition.match(regex);

            if (match && match[1]) {
                // 解码可能存在的URL编码
                return decodeURIComponent(match[1].replace(/\+/g, ' '));
            }

            return null;
        },
        er(row) {
            this.download.id.push(row.tagId)
            this.$confirm('确定要下载该压缩包吗?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(async () => {
                const res = await this.$request.post(
                    "/api/video/user/download", this.download, { responseType: 'blob' }
                );
                if (res.status === 200) {
                    const disposition = res.headers['content-disposition']
                    const filename = this.extractFilenameFromContentDisposition(disposition);

                    const url = window.URL.createObjectURL(new Blob([res.data], { type: 'application/zip' }));
                    const aLink = document.createElement('a');
                    aLink.href = url;
                    aLink.download = ''; // 设置压缩包文件名
                    if (filename) {
                        aLink.download = filename
                    } else {
                        aLink.download = 'your_archive_filename.zip';
                    }
                    document.body.appendChild(aLink);

                    aLink.click();
                    setTimeout(() => {
                        window.URL.revokeObjectURL(url);
                        document.body.removeChild(aLink);
                    }, 0);
                }
            }).catch((e) => {
                console.log(e)
            });
        }

    },
};
</script>
  
<style scoped>
.el-pagination {
    margin-top: 10px;
}

.status-reviewed {
    pointer-events: none;
    cursor: not-allowed;
    color: #909399;
}

.el-dropdown-link {
    cursor: pointer;
    color: #409EFF;
}

.el-icon-arrow-down {
    font-size: 12px;
}

.el-row {
    margin-bottom: 20px;
}

.el-row:last-child {
    margin-bottom: 0px;
}
</style>