package com.mmy.yiyi.mvp_okhttp_retrofit;

import java.io.Serializable;
import java.util.List;

/*
 *
 * 创建自帅气的 清川 on 2020/6/16
 */
public class Bean2 implements Serializable {

    private int code;
    private String title;
    private String detail;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    private List<DataBean> data;

    public List<DataBean> getData() {

        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * type : LoginDTO
         * attributes : {"passFlag":false,"oauth2AccessToken":{"access_token":"9ca01ca3-28a7-4011-aaa1-d5d08509f0e9","token_type":"bearer","refresh_token":"87c73a05-e04c-4447-b480-10dda10303eb","expires_in":59993,"scope":"all"}}
         */

        private String type;
        private AttributesBean attributes;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public AttributesBean getAttributes() {
            return attributes;
        }

        public void setAttributes(AttributesBean attributes) {
            this.attributes = attributes;
        }

        public static class AttributesBean {
            /**
             * passFlag : false
             * oauth2AccessToken : {"access_token":"9ca01ca3-28a7-4011-aaa1-d5d08509f0e9","token_type":"bearer","refresh_token":"87c73a05-e04c-4447-b480-10dda10303eb","expires_in":59993,"scope":"all"}
             */

            private boolean passFlag;
            private Oauth2AccessTokenBean oauth2AccessToken;

            public boolean isPassFlag() {
                return passFlag;
            }

            public void setPassFlag(boolean passFlag) {
                this.passFlag = passFlag;
            }

            public Oauth2AccessTokenBean getOauth2AccessToken() {
                return oauth2AccessToken;
            }

            public void setOauth2AccessToken(Oauth2AccessTokenBean oauth2AccessToken) {
                this.oauth2AccessToken = oauth2AccessToken;
            }

            public static class Oauth2AccessTokenBean {
                /**
                 * access_token : 9ca01ca3-28a7-4011-aaa1-d5d08509f0e9
                 * token_type : bearer
                 * refresh_token : 87c73a05-e04c-4447-b480-10dda10303eb
                 * expires_in : 59993
                 * scope : all
                 */

                private String access_token;
                private String token_type;
                private String refresh_token;
                private int expires_in;
                private String scope;

                public String getAccess_token() {
                    return access_token;
                }

                public void setAccess_token(String access_token) {
                    this.access_token = access_token;
                }

                public String getToken_type() {
                    return token_type;
                }

                public void setToken_type(String token_type) {
                    this.token_type = token_type;
                }

                public String getRefresh_token() {
                    return refresh_token;
                }

                public void setRefresh_token(String refresh_token) {
                    this.refresh_token = refresh_token;
                }

                public int getExpires_in() {
                    return expires_in;
                }

                public void setExpires_in(int expires_in) {
                    this.expires_in = expires_in;
                }

                public String getScope() {
                    return scope;
                }

                public void setScope(String scope) {
                    this.scope = scope;
                }
            }
        }
    }
}
