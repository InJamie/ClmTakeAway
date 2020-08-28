<template>
    <div class="mui-content">
        <div><img :src="logo" alt="" class="logo"/></div>

        <div class="mui-row" style="margin-bottom: 95px">
            <!-- 左侧菜单 -->
            <div class="mui-col-xs-3" style="border-right: 1px solid #c8c7cc">
                <div id="segmentedControls" class="mui-segmented-control mui-segmented-control-inverted mui-segmented-control-vertical">
                    <a class="mui-control-item":class="{'menu-active':menuIndex==index1}" @click="menuIndex = index1" v-for="(item,index1) in data.data">{{item.name}}</a>
                </div>
            </div>
            <!-- 商品列表 -->
            <div id="segmentedControlContents" class="mui-col-xs-9">
                <div v-for="(menu,index) in data.data">
                    <div class="itembox mui-row" v-for="item in menu.foods" v-show="index == menuIndex">
                        <div class="mui-col-xs-3">
                            <img :src="item.icon"/>
                        </div>
                        <div class="mui-col-xs-9">
                            <div class="item">
                                <div class="itemmain">
                                    {{item.name}}
                                </div>
                                <div class="itemsub">
                                    {{item.description}}
                                </div>
                            </div>
                            <div class="operation">
                                <div class="operationPrice">￥{{item.price}}</div>
                                <div class="operationSelect">
                                    <span class="mui-icon mui-icon-minus operationMinus" @click="changeQuantity(item,'minus')"></span>
                                    <span>{{item.quantity}}</span>
                                    <span class="mui-icon mui-icon-plus operationPlus" @click="changeQuantity(item,'plus')"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 底部菜单 -->
        <div style="bottom:50px;" class="mui-bar mui-bar-tab cart-box" id="cart-box">
            <div class="cart-container">
                <div class="cell1">
                    <div class="cart-icon-box">
                        <span class="mui-icon mui-icon-contact">
                          <span class="mui-badge" id="goodsNum">{{totalQuantity}}</span>
                        </span>
                    </div>
                </div>
                <div class="cell12">
                    ￥<span id="totalMoney">{{totalPrice}}</span>
                </div>
                <div class="cell2" @click="clear">
                    <span class="mui-icon mui-icon-trash"></span>
                    清空餐车
                </div>
                <div class="cell3" @click="submit">
                    <span class="mui-icon mui-icon-checkmarkempty"></span>
                    确认下单
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import { Toast } from 'mint-ui';
    export default {
        name: "Cart",
        data() {
            return {
                totalQuantity:0,
                totalPrice:0,
                menuIndex: 0,
                logo: "../static/1.jpg",
                data:{
                    "code": 0,
                    "msg": "成功",
                    "data":null
                }
            }
        },
        created(){
            const _this = this
            axios.get('http://localhost:8020/product-service/productCategory/listvo').then(function (resp) {
                _this.data = resp.data
                console.log(resp)
            })

        },
        methods: {
            //提交
            submit(){
                const _this = this
                if(this.$store.state.selectedArray.length == 0) {
                    let instance = Toast('请选择商品');
                    setTimeout(() => {
                        instance.close();
                    }, 1000)
                    return
                }
                this.$router.push('/info')
            },
            //清空购物车
            clear(){
                this.totalQuantity=0;
                this.totalPrice=0;
                //菜品的数量设置为0
                for(var i = 0; i < this.data.data.length;i++){
                    var item = this.data.data[i];
                    for(var j=0;j<item.foods.length;j++){
                        item.foods[j].quantity = 0;
                    }
                }
                //清空已选数组
                this.$store.state.selectedArray=[]
            },
            changQuantity1(item,type){
              switch (type) {

              }
            },
            changeQuantity(item,type){
                switch (type) {
                    case "minus":
                        if(item.quantity == 0)return;
                        item.quantity--;
                        this.totalQuantity--;
                        this.totalPrice -= item.price;
                        for(var i=0;i<this.$store.state.selectedArray.length;i++){
                            if(item.id == this.$store.state.selectedArray[i].productId){
                                this.$store.state.selectedArray[i].productQuantity = item.quantity
                                if(item.quantity==0) this.$store.state.selectedArray.splice(i,1)
                                return;
                            }
                        }
                        break;
                    case "plus":
                        item.quantity++;
                        if(item.quantity <= item.stock){
                            this.totalQuantity++;
                            this.totalPrice += item.price;
                        }else{
                            item.quantity = item.stock;
                            let instance = Toast(item.name+'已被你抢空！');
                            setTimeout(() => {
                                instance.close();
                            }, 1000)
                            return
                        }
                        //查询是否已经存在
                        for(var i=0;i<this.$store.state.selectedArray.length;i++){
                            if(item.id == this.$store.state.selectedArray[i].productId){
                                this.$store.state.selectedArray[i].productQuantity = item.quantity
                                return;
                            }
                        }
                        //添加对象
                        this.$store.state.selectedArray.push({
                            productId:item.id,
                            productQuantity:item.quantity
                        });
                        break;
                }
            }
        }
    }
</script>

<style scoped>
    .operation{
        width: 220px;
        height: 20px;
        margin-top: 3px;
    }
    .operationPrice{
        float: left;
        width: 50px;
        height: 100%;
        font-size: 18px;
        font-weight: bold;
        color: red;
    }
    .operationType{
        float: left;
        position: relative;
        left: 10px;
        width: 60px;
        height: 100%;
    }
    .operationSelect{
        float: left;
        width: 110px;
        height: 100%;
        position: relative;
        left: 10px;
    }
    .operationMinus{
        color: red;
        float: left;
        margin-left: 10px;
        font-weight: bold;
    }
    .operationPlus{
        color:green;
        float: right;
        margin-right: 15px;
        font-weight: bold;
    }
    .mui-row.mui-fullscreen>[class*="mui-col-"] {
        height: 100%;
    }
    .mui-col-xs-3 {
        overflow-y: auto;
        height: 100%;
    }
    .mui-segmented-control .mui-control-item {
        line-height: 50px;
        width: 100%;
    }
    .mui-segmented-control.mui-segmented-control-inverted .mui-control-item.mui-active {
        background-color: #fff;
    }

    #segmentedControlContents,#segmentedControls{
        background-color: white;
    }

    #segmentedControlContents{
        padding: 15px 0 0 10px;
    }
    .mui-content{
        padding: 0;
        background-color: white;
    }
    .itembox{
        margin: 0 0 16px;
        padding: 0 0 5px;
        border-bottom: 1px silver solid;
    }
    img{
        width: 60px;
        height: 60px;
        vertical-align: center;
    }
    .oper-icon{
        display: inline-block;
        float: right;
        padding-right: 10%;
        /*color: blue;*/
        position: relative;
        left: 20px;
        background-color: green;
        width: 60px;
    }
    .item{
        width: 250px;
        height: 40px;
        text-align: left;
    }
    .itemmain{
        font-size: 14px;
        font-weight: bold;
    }
    .itemsub{
        font-size: 13px;
        font-family: 'Helvetica Neue', Helvetica, sans-serif;
    }

    .logo{
        width: 100%;
        height: 100%;
    }
    .menu-active{
        color: red;
        background-color: #c8c7cc;
    }

    .cell1, .cell2, .cell3 {
        display: inline-block;
    }
    .cart-container{
        display: flex;
        padding: 0;
        margin: 0;
        height: 51px;
    }
    .cell1{
        flex: 2;
        background-color: #141d27;
        color: #cccccc;
    }

    .cell12{
        flex: 2;
        background-color: #141d27;
        text-align: center;
        padding-right: 0;
        color: white;
        font-size: 17px;
        line-height: 51px;
    }
    .cell2{
        flex: 3;
        background-color: #dd524d;
        text-align: center;
        padding-left: 0;
        margin: 0;
        color: white;
        font-size: 15px;
    }

    .cell3{
        flex: 3;
        background-color: #007aff;
        text-align: center;
        padding-right: 10px;
        color: white;
        font-size: 15px;
    }
    .cart-icon-box{
        border: black 5px solid;
        border-radius: 50%;
        height: 50px;
        width: 50px;
        text-align: center;
        background-color: #6c757d;
        z-index: 100;
        position: relative;
        top: -15px;
        left: 10%;
    }


</style>
