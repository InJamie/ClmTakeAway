import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import AddProduct from "../views/AddProduct"
import ProductManage from "../views/ProductManage"
import EditProduct from "../views/EditProduct"
import OrderManage from "../views/OrderManage"

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: '商品模块',
    component: Home,
    redirect: '/addProduct',
    show:true,
    children:[
      {
        path:'/addProduct',
        name:'添加商品',
        show:true,
        component: AddProduct
      },
      {
        path:'/productManage',
        name:'商品管理',
        show:true,
        component: ProductManage
      },
      {
        path:'/editProduct',
        name:'修改商品',
        show:false,
        component: EditProduct
      }
    ]
  },
  {
    path: '/',
    name: '订单模块',
    component: Home,
    show:true,
    children:[
      {
        path:'/orderManage',
        name:'订单管理',
        show:true,
        component: OrderManage
      }
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
