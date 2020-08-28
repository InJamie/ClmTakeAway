# 买家端

### 商品列表

```
GET /buyer/product/list
```

参数

```
无
```

返回

```json
{
    "code": 0,
    "msg": "成功",
    "data": [
        {
            "name": "早餐",
            "type": 1,
            "foods": [
                {
                    "id": "2",
                    "name": "豆浆",
                    "price": 3.5,
                    "description": "很好喝",
                    "icon": "http://5b0988e595225.cdn.sohucs.com/images/20181101/225d20df2bc14cefb363686d90d47004.jpeg",
                    "quantity": 0,
                    "stock": 200
                }
            ]
        },
        {
            "name": "午餐",
            "type": 2,
            "foods": [
                {
                    "id": "1",
                    "name": "红烧肉",
                    "price": 33.50,
                    "description": "很好吃",
                    "icon": "http://n.sinaimg.cn/sinacn10/320/w640h480/20180827/5682-hifuvph4790369.jpg",
                    "quantity": 0,
                    "stock": 200
                }
            ]
        }
    ]
}
```

### 创建订单

```
POST /buyer/order/create
```

参数

```json
name: "张三"
phone: "13678987656"
address: "科技路"
id: "ax001"
items: [{
    productId: "1",
    productQuantity: 2
}]

```

返回

```json
{
  "code": 0,
  "msg": "成功",
  "data": {
      "orderId": "1580478626065915735" 
  }
}
```

### 订单列表

```
GET /buyer/order/list
```

参数

```
buyerId: 18eu2jwk2kse3r42e2e
page: 0 //从第0页开始
size: 10
```

返回

```json
{
  "code": 0,
  "msg": "成功",
  "data": [
    {
      "orderId": "161873371171128075",
      "buyerName": "张三",
      "buyerPhone": "18868877111",
      "buyerAddress": "科技路",
      "buyerOpenid": "18eu2jwk2kse3r42e2e",
      "orderAmount": 0,
      "orderStatus": 0,
      "payStatus": 0,
      "createTime": 1490171219,
      "updateTime": 1490171219,
      "orderDetailList": null
    },
    {
      "orderId": "161873371171128076",
      "buyerName": "张三",
      "buyerPhone": "18868877111",
      "buyerAddress": "科技路",
      "buyerOpenid": "18eu2jwk2kse3r42e2e",
      "orderAmount": 0,
      "orderStatus": 0,
      "payStatus": 0,
      "createTime": 1490171219,
      "updateTime": 1490171219,
      "orderDetailList": null
    }]
}
```

### 查询订单详情

```
GET /buyer/order/detail
```

参数

```
buyerId: 18eu2jwk2kse3r42e2e
orderId: 161899085773669363
```

返回

```json
{
    "code": 0,
    "msg": "成功",
    "data": {
          "orderId": "161899085773669363",
          "buyerName": "李四",
          "buyerPhone": "18868877111",
          "buyerAddress": "科技路",
          "buyerOpenid": "18eu2jwk2kse3r42e2e",
          "orderAmount": 18,
          "orderStatus": 0,
          "payStatus": 0,
          "createTime": 1490177352,
          "updateTime": 1490177352,
          "orderDetailList": [
            {
                "detailId": "161899085974995851",
                "orderId": "161899085773669363",
                "productId": "157875196362360019",
                "productName": "招牌奶茶",
                "productPrice": 9,
                "productQuantity": 2,
                "productIcon": "http://xxx.com",
                "productImage": "http://xxx.com"
            }
        ]
    }
}
```

### 取消订单

```
PUT /buyer/order/cancel
```

参数

```
buyerId: 18eu2jwk2kse3r42e2e
orderId: 161899085773669363
```

返回

```json
{
    "code": 0,
    "msg": "成功",
    "data": null
}
```

### 完结订单

```
PUT /buyer/order/finish
```

参数

```
orderId: 161899085773669363
```

返回

```json
{
    "code": 0,
    "msg": "成功",
    "data": null
}
```

# 卖家端

### 查询所有商品分类

```
GET /seller/product/findAllProductCategory
```

参数

```
无
```

返回

```json
{
  code: 0,
  msg: "成功",
  data: {
    content:[
      {
        name: "热销榜",
        type: 2
      },
      {
        name: "夜宵",
        type: 3
      },
      {
        name: "午餐",
        type: 10
      },
      {
        name: "小吃",
        type: 11
      },
      {
        name: "早餐",
        type: 1
      }
    ]
  }
```

### 添加商品

```
POST /seller/product/add
```

参数

```json
{
  name: "肉夹馍",
  price: 16,
  stock: 107,
  description: "好吃好吃",
  icon: "https://s1.st.meishij.net/rs/50/123/6030800/n6030800_152708155351112.jpg",
  productStatus: 1,
  category: {
    categoryId: 1,
    categoryName: "热销榜"
  }
}
```

返回

```json
{
    "code": 0,
    "msg": "成功",
    "data": null
}
```

### 查询商品

```
GET /seller/product/list
```

参数

```
page: 0 //从第0页开始
size: 10
```

返回

```json
{
  code: 0,
  msg: "成功",
  data: {
    content: [
      {
        status: true,
        id: 1,
        name: "肉夹馍",
        price: 16,
        stock: 107,
        description: "好吃好吃",
        icon: "https://s1.st.meishij.net/rs/50/123/6030800/n6030800_152708155351112.jpg",
        category: {
          categoryId: 1,
          categoryName: "热销榜",
          categoryType: 2,
          createTime: "2020-01-07T09:22:48.000+0000",
          updateTime: "2020-01-07T09:22:48.000+0000"
        }
      }
    ],
    pageable: {
      sort: {
        unsorted: true,
        sorted: false,
        empty: true
      },
      offset: 0,
      pageNumber: 0,
      pageSize: 3,
      paged: true,
      unpaged: false
    },
    last: false,
    totalElements: 12,
    totalPages: 4,
    size: 3,
    sort: {
      unsorted: true,
      sorted: false,
      empty: true
    },
    first: true,
    numberOfElements: 3,
    number: 0,
    empty: false
  }
}
```

### 通过id查询商品

```
GET /seller/product/findById
```

参数

```
id: 1
```

返回

```json
{
  code: 0,
  msg: "成功",
  data: {
    status: true,
    id: 1,
    name: "肉夹馍",
    price: 16,
    stock: 107,
    description: "好吃好吃",
    icon: "https://s1.st.meishij.net/rs/50/123/6030800/n6030800_152708155351112.jpg",
    category: {
      categoryId: 1,
      categoryName: "热销榜",
      categoryType: 2,
      createTime: "2020-01-07T09:22:48.000+0000",
      updateTime: "2020-01-07T09:22:48.000+0000"
    }
  }
}
```

### 通过id删除商品

```
DELETE /seller/product/delete/
```

参数

```
id: 1
```

返回

```json
{
    "code": 0,
    "msg": "成功",
    "data": null
}
```

### 修改商品状态

```
PUT /seller/product/updateStatus
```

参数

```json
{
  status: false
  id: 1
  name: "肉夹馍"
  price: 16
  stock: 107
  description: "好吃好吃"
  icon: "https://s1.st.meishij.net/rs/50/123/6030800/n6030800_152708155351112.jpg"
  category: Object
  categoryId: 1
  categoryName: "热销榜"
  categoryType: 2
  createTime: "2020-01-07T09:22:48.000+0000"
  updateTime: "2020-01-07T09:22:48.000+0000"
}
```

返回

```json
{
    "code": 0,
    "msg": "成功",
    "data": null
}
```

### 修改商品

```
PUT /seller/product/update
```

参数

```json
{
    status: true,
    id: 1,
    name: "肉夹馍",
    price: 16,
    stock: 107,
    description: "好吃好吃",
    icon: "https://s1.st.meishij.net/rs/50/123/6030800/n6030800_152708155351112.jpg",
    category: {
        categoryId: 1,
        categoryName: "热销榜",
        categoryType: 2,
        createTime: "2020-01-07T09:22:48.000+0000",
        updateTime: "2020-01-07T09:22:48.000+0000"
    }
}
```

返回

```json
{
    "code": 0,
    "msg": "成功",
    "data": null
}
```

### 查询订单

```
GET /seller/order/list
```

参数

```
page: 0 //从第0页开始
size: 10
```

返回

```json
{
  code: 0,
  msg: "成功",
  data: {
    content: [
      {
        orderId: "1579074660492865989",
        buyerName: "小溪",
        buyerPhone: "13567676767",
        buyerAddress: "小寨",
        buyerOpenid: "000999888",
        orderAmount: 88,
        orderStatus: 2,
        payStatus: 0,
        createTime: "2020-01-15T07:51:00.000+0000",
        updateTime: "2020-01-25T15:49:09.000+0000"
      }
    ],
    pageable: {
      sort: {
        unsorted: true,
        sorted: false,
        empty: true
      },
      offset: 0,
      pageNumber: 0,
      pageSize: 1,
      paged: true,
      unpaged: false
    },
    last: false,
    totalElements: 31,
    totalPages: 31,
    size: 1,
    sort: {
      unsorted: true,
      sorted: false,
      empty: true
    },
    first: true,
    numberOfElements: 1,
    number: 0,
    empty: false
  }
}
```

### 取消订单

```
PUT /seller/order/cancel
```

参数

```
orderId:"1579074660492865989"
```

返回

```json
{
    "code": 0,
    "msg": "成功",
    "data": null
}
```

### 完结订单

```
PUT /seller/order/finish
```

参数

```
orderId:"1579074660492865989"
```

返回

```json
{
    "code": 0,
    "msg": "成功",
    "data": null
}
```
