
# 项目名称：Hzero-order-24913
## 项目负责人：李享定
## 项目概述
### 开发目的：通过该考核来测试培训人员对Hzero的掌握情况。
### 开发内容：开发一个销售订单管理平台，来查询、录入、编辑、导出销售订单信息及销售订单报表等。
### 开发框架：Hzero (0.10.0)
### 开发列表：
#### 1.销售订单汇总查询页面
#### 2.录入、编辑、查看销售订单页面
#### 3.导出销售订单信息至Excel
#### 4.销售订单定时关闭
#### 5.按钮权限控制
### 数据库设计
   #### 主数据表
   * 公司主数据：hodr_company 
      * 表设计：[hodr_company](./img/hodr_company.png)
      * 索引： [hodr_company_index](./img/hodr_company_index.png)
   * 客户主数据：hodr_customer
      * 表设计：[hodr_customer](./img/hodr_customer.png)
      * 索引： [hodr_customer_index](./img/hodr_customer_index.png)
   * 物料主数据：hodr_item
       * 表设计：[hodr_item](./img/hodr_item.png)
       * 索引： [hodr_item_index](./img/hodr_item_index.png)
   #### 业务数据表
   * 订单头数据：hodr_so_header
       * 表设计：[hodr_so_header](./img/hodr_so_header.png)
       * 索引： [hodr_so_header_index](./img/hodr_so_header_index.png)
   * 订单行数据：hodr_so_line
       * 表设计：[hodr_so_line](./img/hodr_so_line.png)
       * 索引： [hodr_so_line_index](./img/hodr_so_line_index.png)
### 实现功能
   * 基于查询公司、客户、销售订单号、物料、订单状态查询销售订单数据
   * 查询订单数据
   * 导出订单数据（基于 Excel）
   * 实现新增/更改/查看销售订单，禁止销售订单被删除        
### 启动说明
#### 1.新建数据库hzero_order
#### 2.运行[hzero_order.sql](./sql/hzero_order.sql)文件，新建数据表，导入数据
#### 3.根据[Hzero本地部署说明](./pdf/Hzero_arrange.pdf)搭建Hzero开发环境，数据库脚本见Hzero本地部署数据库。
#### 4.修改本项目[application.yml](src/main/resources/application.yml)文件中MySQL数据库地址、用户名、密码以及euraka地址。
#### 5.修改本项目[bootstrap.yml](src/main/resources/bootstrap.yml)文件中配置中心地址。
#### 6.Hzero本地部署完成，按register、config、gateway、swagger、oauth、iam顺序启动服务。
#### 7.打开[euraka](/http://dev.hzero.org:8000/)注册中心地址查看服务注册情况，打开[swagger](http://dev.hzero.org:8080/swagger/swagger-ui.html)查看接口详情

### 接口说明
#### /v1/orderDetail/query/orderHeaderAndLineInfo
#### 根据订单头编号查询订单头信息和订单行信息
#### /v1/orderDetail/query/deriveOrderHeaderAndLines
#### 导出订单信息
#### /v1/orderDetail/query/addOrder
#### 新增订单
#### /v1/orderDetail/query/modifyOrder
#### 更新订单
#### /v1/orderTotal
#### 根据选定条件查询订单信息
#### /v1/orderTotal/query/company
#### 根据公司代码或名称查询公司信息
#### /v1/orderTotal/query/customer
#### 根据客户编码或名称查询客户信息
#### /v1/orderTotal/query/item
#### 根据物料描述或编码查询物料信息
#### /v1/orderTotal/query/allCompany
#### 查询所有公司代码和名称信息
#### /v1/orderTotal/query/allCustomer
#### 根据公司Id或名称查询客户信息
#### /v1/orderTotal/query/allItem
#### 查询所有物料信息
