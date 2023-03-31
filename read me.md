# 单元测试最佳实践

## 单元测试编写方案

1. 单元测试基类com.hellobike.testing.BaseTest，其他单元测试继承该类；
2. 每一个使用到的方法，都需要编写单元测试用例；
3. 编写测试用例时候需要考虑正常流程、边界情况、异常情况，并且尽量覆盖所有分支。

## 单元测试编写要求

### 良好的命名

1. 测试命名应该由两个部分，可以良好的表达测试意图
    1. 被测试方法的名称
    2. 测试的场景
2. 至少应该包含被测试方法名称

#### 错误例子

```java
    @Test
    public void query(){
        OrderQueryRequest request=new OrderQueryRequest();
        request.setBuyerId(IPHONE_BUYER_ID);
        queryOrderListByParam(request);
    }
```

#### 正确例子

```java
    @Test
    public void queryOrderListByBuyerId(){
        OrderQueryRequest request=new OrderQueryRequest();
        request.setBuyerId(IPHONE_BUYER_ID);
        queryOrderListByParam(request);
    }

```

### 正确的排序

1. 先创建对象
2. 调用方法
3. 设置断言

#### 错误例子

```java
    @Test
    public void createOrder(){
        OrderCreateRequest request=createOrderRequest();
        Assertions.assertNotNull(orderService.createOrder(request),"返回结果为空");
    }
```

#### 正确例子

```
    @Test
    public void createOrder(){
        OrderCreateRequest request=createOrderRequest();
        Result<Void> result=orderService.createOrder(request);
        Assertions.assertNotNull(result,"返回结果为空");
    }

```

### 不要使用魔法值/局部变量
1. 让每个参数的含义更加明确
2. 在用例中可以复用参数

#### 错误例子

```
    @Test
    public void createOrder() {
        OrderCreateRequest request=new OrderCreateRequest();
        request.setBuyerId(138995358538520100L);
        request.setBuyerName("小芳");
        request.setSellerId(138995358538520101L);
        request.setSellerName("大壮数码");
        request.setGoodTitle("Apple iPhone 14ProMax");
        request.setPrice("8169.00");
        Result<Void> result=orderService.createOrder(request);
        Assertions.assertNotNull(result,"返回结果为空");
    }
```

#### 正确例子

```
    public static final Long IPHONE_BUYER_ID = 138995358538520100L;
    public static final String IPHONE_BUYER_NAME = "小芳";
    public static final Long IPHONE_SELLER_ID = 138995358538520101L;
    public static final String IPHONE_SELLER_NAME = "大壮数码";
    public static final String IPHONE_GOODS_TITLE = "Apple iPhone 14ProMax";
    public static final String IPHONE_PRICE = "8169.00";
    public static final String IPHONE_PROMOTIONAL_PRICE = "6169.00";
    @Test
    public void createOrder(){
        OrderCreateRequest request=createOrderRequest();
        Result<Void> result=orderService.createOrder(request);
        Assertions.assertNotNull(result, "返回结果为空");
    }
    
    private OrderCreateRequest createOrderRequest() {
        OrderCreateRequest request = new OrderCreateRequest();
        request.setBuyerId(IPHONE_BUYER_ID);
        request.setBuyerName(IPHONE_BUYER_NAME);
        request.setSellerId(IPHONE_SELLER_ID);
        request.setSellerName(IPHONE_SELLER_NAME);
        request.setGoodTitle(IPHONE_GOODS_TITLE);
        request.setPrice(IPHONE_PRICE);
        return request;
    }
```