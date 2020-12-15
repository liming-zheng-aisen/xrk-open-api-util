# xrk-open-api-util 是向日葵妈妈鉴权SDK工具包

## 环境说明

    JDK 1.8+
    依赖fastjson
    
## 快速使用（三步快速接入）

### 【step01】拉取代码

    git clone https://github.com/1308404897/xrk-open-api-util.git
   
### 【step02】参考Demo里面的示例，试着运行案例

               /**
                 * 模拟【下单拦截接口】
                 * @param allowDownOrder
                 * @return
                 */
                public static ApiResponse isAllowDownOrder(AllowDownOrder allowDownOrder){
                    try {
                        if (OpenApiSdk.isAccess(JsonUtil.parseObjectToMap(allowDownOrder),appKey)){
                            //TODO 写自己的业务，判断是否允许下单
                            //...............
                            return ApiResponse.ok();
                        }else {
                            return ApiResponse.error(30001,"鉴权失败，超时或密钥过时","请稍等重试～");
                        }
                    }catch (Exception e){
                        return ApiResponse.error(40004,e.getMessage(),"哦豁，服务器开小差了～");
                    }
                }
            
                /**
                 * 模拟【订单同步】
                 * @param syncOrder
                 * @return
                 */
                public static ApiResponse syncOrder(SyncOrder syncOrder){
                    try {
                        if (OpenApiSdk.isAccess(JsonUtil.parseObjectToMap(syncOrder),appKey)){
                            //TODO 写自己的业务,同步订单
                            //...............
                            return ApiResponse.ok();
                        }else {
                            return ApiResponse.error(30001,"鉴权失败，超时或密钥过时",null);
                        }
                    }catch (Exception e){
                        return ApiResponse.error(40004,e.getMessage(),null);
                    }
                }

    
### 【step03】将openapi包和util包下面的类拷贝到自己的工程，开发自己的业务，以下是主要的类说明
    openapi包:
       BaseAccessData ：鉴权的基础类，任何需要传输的类必须继承与它
       AllowDownOrder ：用户下单前，向日葵平台会向第三方平台发送订单拦截请求，询问是否允许该用户下单
       SyncOrder ： 同步订单数据，下单成功后，自动同步订单给第三方平台，实时同步
       OpenApiSdk：开发平台的SDK，用途：鉴权、数据签名
       ApiResponse：响应请求信息

    util包：
       JsonUtil ： JSON工具类
       MD5Util  ： MD5加密工具类
       SignUtil ： 签名工具类
       
## 完成开发后，把以下信息同步到先日葵妈妈平台，与开发人员进行联调
    1、下单前拦截接口
    2、同步数据接口
    3、授权密钥【appKey】
       
