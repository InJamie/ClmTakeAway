<template>
    <div style="margin-top: 60px;margin-left:80px;border: 0px solid red;" >
        <el-table
                :data="tableData"
                border
                style="width: 100%">
            <el-table-column
                    fixed
                    prop="orderId"
                    label="订单编号"
                    width="170">
            </el-table-column>
            <el-table-column
                    prop="buyerName"
                    label="买家姓名"
                    width="100">
            </el-table-column>
            <el-table-column
                    prop="buyerPhone"
                    label="联系电话"
                    width="130">
            </el-table-column>
            <el-table-column
                    prop="buyerAddress"
                    label="收货地址"
                    width="170">
            </el-table-column>
            <el-table-column
                    prop="orderAmount"
                    label="订单总价"
                    width="80">
            </el-table-column>
            <el-table-column
                    label="订单状态"
                    width="80">
                <template slot-scope="scope">
                    {{transformOrderStatus(scope.row.orderStatus)}}
                </template>
            </el-table-column>
            <el-table-column
                    label="支付状态"
                    width="80">
                <template slot-scope="scope">
                    {{transformPayStatus(scope.row.payStatus)}}
                </template>
            </el-table-column>
            <el-table-column label="创建时间"
                    width="160">
                <template slot-scope="scope">
                    {{dateFormat(scope.row.createTime)}}
                </template>
            </el-table-column>
            <el-table-column label="操作" width="150">
                <template slot-scope="scope">
                    <el-button
                            :disabled="scope.row.orderStatus==2 || scope.row.orderStatus==1"
                            size="mini"
                            type="danger"
                            @click="cancel(scope.row)">取消</el-button>
                    <el-button
                            :disabled="scope.row.orderStatus==1 || scope.row.orderStatus==2"
                            size="mini"
                            type="success"
                            @click="finish(scope.row)">完成</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination style="margin-top: 20px;float: right"
                       background
                       layout="prev, pager, next"
                       :page-size="pageSize"
                       :total="total"
                       @current-change="page">
        </el-pagination>
    </div>

</template>

<script>
    export default {
        data() {
            return {
                tableData:[
                    {
                    orderId: "1584417036708983000",
                    buyerName: "张三",
                    buyerPhone: "123456",
                    buyerAddress: "科技路",
                    buyerOpenid: "sdfyc123Werdsfd98712Bdc",
                    orderAmount: 53,
                    orderStatus: 0,
                    payStatus: 1,
                    createTime: "2020-03-17T03:50:36.000+00:00",
                    updateTime: "2020-03-17T03:50:56.000+00:00"
                },
                    {
                        orderId: "1584417079198165747",
                        buyerName: "张三",
                        buyerPhone: "123456",
                        buyerAddress: "科技路",
                        buyerOpenid: "sdfyc123Werdsfd98712Bdc",
                        orderAmount: 53,
                        orderStatus: 2,
                        payStatus: 1,
                        createTime: "2020-03-17T03:51:19.000+00:00",
                        updateTime: "2020-03-17T03:52:32.000+00:00"
                    },
                    {
                        orderId: "1584417180668768071",
                        buyerName: "张三",
                        buyerPhone: "123456",
                        buyerAddress: "科技路",
                        buyerOpenid: "sdfyc123Werdsfd98712Bdc",
                        orderAmount: 53,
                        orderStatus: 1,
                        payStatus: 1,
                        createTime: "2020-03-17T03:53:00.000+00:00",
                        updateTime: "2020-03-17T03:53:59.000+00:00"
                    },
                    {
                        orderId: "1584417441554104246",
                        buyerName: "张三",
                        buyerPhone: "123",
                        buyerAddress: "科技路",
                        buyerOpenid: "sdfyc123Werdsfd98712Bdc",
                        orderAmount: 16,
                        orderStatus: 1,
                        payStatus: 1,
                        createTime: "2020-03-17T03:57:21.000+00:00",
                        updateTime: "2020-03-17T03:58:18.000+00:00"
                    },
                    {
                        orderId: "1586332573355940611",
                        buyerName: "123",
                        buyerPhone: "123",
                        buyerAddress: "123",
                        buyerOpenid: "sdfyc123Werdsfd98712Bdc",
                        orderAmount: 33,
                        orderStatus: 2,
                        payStatus: 1,
                        createTime: "2020-04-08T07:56:13.000+00:00",
                        updateTime: "2020-04-08T07:56:35.000+00:00"
                    }],
                pageSize:5,
                total:10,
            }
        },
        methods:{
            transformOrderStatus(status){
                switch (status){
                    case 0: return '新订单';break;
                    case 1: return '已完成';break;
                    case 2: return '已取消';break;
                }
            },
            transformPayStatus(status){
                switch (status){
                    case 0: return '未支付';break;
                    case 1: return '已支付';break;
                }
            },
            dateFormat(time) {
                var date = new Date(time);
                var year=date.getFullYear();
                var month= date.getMonth()+1<10 ? "0"+(date.getMonth()+1) : date.getMonth()+1;
                var day=date.getDate()<10 ? "0"+date.getDate() : date.getDate();
                var hours=date.getHours()<10 ? "0"+date.getHours() : date.getHours();
                var minutes=date.getMinutes()<10 ? "0"+date.getMinutes() : date.getMinutes();
                var seconds=date.getSeconds()<10 ? "0"+date.getSeconds() : date.getSeconds();
                return year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
            },
            page(currentPage){
                const _this = this
                // axios.get('http://'+this.$store.state.host+':8181/seller/order/list/'+currentPage+'/'+_this.pageSize).then(function (resp) {
                //     _this.tableData = resp.data.data.content
                //     _this.pageSize = resp.data.data.size
                //     _this.total = resp.data.data.totalElements
                // })
            },
            cancel(row) {
                const _this = this
                _this.$alert('订单【'+row.orderId+'】已取消', '成功', {
                    confirmButtonText: '确定',
                    callback: action => {
                        location.reload()
                    }
                });
                axios.put('http://localhost:8020/order-service/seller/order/cancel'+row.orderId).then(function (resp) {
                    if(resp.data.code == 1){
                        _this.$alert('订单【'+row.orderId+'】状态异常', '错误', {
                            confirmButtonText: '确定'
                        });
                    }
                    if(resp.data.code == 0){
                        _this.$alert('订单【'+row.orderId+'】已取消', '成功', {
                            confirmButtonText: '确定',
                            callback: action => {
                                location.reload()
                            }
                        });
                    }
                })
            },
            finish(row) {
                if(row.payStatus == 0){
                    this.$alert('订单【'+row.orderId+'】未支付，无法完成该订单', '错误', {
                        confirmButtonText: '确定'
                    });
                }else if(row.orderStatus == 2){
                    this.$alert('订单【'+row.orderId+'】已取消，无法完成该订单', '错误', {
                        confirmButtonText: '确定',
                    });
                }else{
                    const _this = this
                    _this.$alert('订单【'+row.orderId+'】已完成', '成功', {
                        confirmButtonText: '确定',
                        callback: action => {
                            location.reload()
                        }
                    });
                    axios.put('http://localhost:8020/order-service/seller/order/finish/'+row.orderId).then(function (resp) {
                        if(resp.data.code == 1){
                            _this.$alert('订单【'+row.orderId+'】状态异常', '错误', {
                                confirmButtonText: '确定'
                            });
                        }
                        if(resp.data.code == 0){
                            _this.$alert('订单【'+row.orderId+'】已完成', '成功', {
                                confirmButtonText: '确定',
                                callback: action => {
                                    location.reload()
                                }
                            });
                        }
                    })
                }
            }
        },
        created() {
            const _this = this
            axios.get('http://localhost:8020/order-service/seller/order/list/1/'+_this.pageSize).then(function (resp) {
                _this.tableData = resp.data.data.content
                _this.pageSize = resp.data.data.size
                _this.total = resp.data.data.totalElements
            })
        }
    }
</script>