/**
 * 
 */
//easyUI表单验证  
/* 验证 */  
$.extend($.fn.validatebox.defaults.rules,  
                {  
                    //密码验证  
                    equals : {  
                        validator : function(value, param) {  
                            return value == $(param[0]).val();  
                        },  
                        message : '密码输入不一致.'  
                    },  
                    // 移动手机号码验证  
                    mobile : {// value值为文本框中的值  
                        validator : function(value) {  
                            var reg = /^1[3|4|5|8|9]\d{9}$/;  
                            return reg.test(value);  
                        },  
                        message : '输入手机号码格式不准确.'  
                    },  
                    combo : {  
                        validator : function(value) {  
                            if (value) {  
                                return true;  
                            } else {  
                                return false;  
                            }  
                        },  
                        message : '不能为空'  
                    },  
                    // 验证电话号码    
                    phone : {  
                        validator : function(value) {  
                            return /^((\d2,3)|(\d{3}\-))?(0\d2,3|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i  
                                    .test(value);  
                        },  
                        message : '格式不正确,请使用下面格式:020-88888888'  
                    },  
                    // 电话号码或手机号码    
                    phoneAndMobile : {  
                        validator : function(value) {  
                            return /^((\d2,3)|(\d{3}\-))?(0\d2,3|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i  
                                    .test(value)  
                                    || /^(13|15|18)\d{9}$/i.test(value);  
                        },  
                        message : '电话号码或手机号码格式不正确'  
                    },  
                    // 验证整数或小数    
                    intOrFloat : {  
                        validator : function(value) {  
                            return /^\d+(\.\d+)?$/i.test(value);  
                        },  
                        message : '请输入数字，并确保格式正确'  
                    },  
                    // 验证整数    
                    integer : {  
                        validator : function(value) {  
                            return /^[+]?[1-9]+\d*$/i.test(value);  
                        },  
                        message : '请输入整数'  
                    },  
                    // 验证是否包含空格和非法字符    
                    unnormal : {  
                        validator : function(value) {  
                            return /.+/i.test(value);  
                        },  
                        message : '输入值不能为空和包含其他非法字符'  
                    },  
                    //验证车牌号码  
                    carNo : {  
                        validator : function(value) {  
                            return /^[\u4E00-\u9FA5][\da-zA-Z]{6}$/.test(value);  
                        },  
                        message : '车牌号码无效（例：粤B12350）'  
                    },  
                    // 用户密码验证(只能包括 _ 数字 字母)  
                    account : {// param的值为[]中值  
                        validator : function(value, param) {  
                            if (value.length < param[0]  
                                    || value.length > param[1]) {  
                                $.fn.validatebox.defaults.rules.account.message = '长度必须在'  
                                        + param[0] + '至' + param[1] + '范围';  
                                return false;  
                            } else {  
                                if (!/(?=.*?[a-zA-Z])(?=.*?[0-9])[a-zA-Z0-9]{8,}$/  
                                        .test(value)) {  
                                    $.fn.validatebox.defaults.rules.account.message = '必须包含数字和字母.';  
                                    return false;  
                                } else {  
                                    return true;  
                                }  
                            }  
                        },  
                        message : '只能数字、字母、下划线组成'  
                    },  
                    // 用户账号验证(只能包括 _ 数字 字母)  
                    username : {  
                        validator : function(value) {  
                            return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i.test(value);  
                        },  
                        message : '用户名不合法（字母开头，允许6-16字符，允许字母数字下划线）'  
                    },  
                    // 汉字验证  
                    CHS : {  
                        validator : function(value) {  
                            return /^[\u0391-\uFFE5]+$/.test(value);  
                        },  
                        message : '只能输入汉字'  
                    },  
                    // 验证身份证    
                    idcard : {  
                        validator : function(num) {  
                            num = num.toUpperCase();  
                            //身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X。  
                            if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(num))) {  
                                return false;  
                            }  
                            //校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。  
                            //下面分别分析出生日期和校验位  
                            var len, re;  
                            len = num.length;  
                            if (len == 15) {  
                                re = new RegExp(  
                                        /^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/);  
                                var arrSplit = num.match(re);  
   
                                //检查生日日期是否正确  
                                var dtmBirth = new Date('19' + arrSplit[2]  
                                        + '/' + arrSplit[3] + '/' + arrSplit[4]);  
                                var bGoodDay;  
                                bGoodDay = (dtmBirth.getYear() == Number(arrSplit[2]))  
                                        && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3]))  
                                        && (dtmBirth.getDate() == Number(arrSplit[4]));  
                                if (!bGoodDay) {  
                                    return false;  
                                } else {  
                                    //将15位身份证转成18位  
                                    //校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。  
                                    var arrInt = new Array(7, 9, 10, 5, 8, 4,  
                                            2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);  
                                    var arrCh = new Array('1', '0', 'X', '9',  
                                            '8', '7', '6', '5', '4', '3', '2');  
                                    var nTemp = 0, i;  
                                    num = num.substr(0, 6) + '19'  
                                            + num.substr(6, num.length - 6);  
                                    for (i = 0; i < 17; i++) {  
                                        nTemp += num.substr(i, 1) * arrInt[i];  
                                    }  
                                    num += arrCh[nTemp % 11];  
                                    return true;  
                                }  
                            }  
                            if (len == 18) {  
                                re = new RegExp(  
                                        /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/);  
                                var arrSplit = num.match(re);  
   
                                //检查生日日期是否正确  
                                var dtmBirth = new Date(arrSplit[2] + "/"  
                                        + arrSplit[3] + "/" + arrSplit[4]);  
                                var bGoodDay;  
                                bGoodDay = (dtmBirth.getFullYear() == Number(arrSplit[2]))  
                                        && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3]))  
                                        && (dtmBirth.getDate() == Number(arrSplit[4]));  
                                if (!bGoodDay) {  
                                    return false;  
                                } else {  
                                    //检验18位身份证的校验码是否正确。  
                                    //校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。  
                                    var valnum;  
                                    var arrInt = new Array(7, 9, 10, 5, 8, 4,  
                                            2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);  
                                    var arrCh = new Array('1', '0', 'X', '9',  
                                            '8', '7', '6', '5', '4', '3', '2');  
                                    var nTemp = 0, i;  
                                    for (i = 0; i < 17; i++) {  
                                        nTemp += num.substr(i, 1) * arrInt[i];  
                                    }  
                                    valnum = arrCh[nTemp % 11];  
                                    if (valnum != num.substr(17, 1)) {  
                                        return false;  
                                    }  
                                    return true;  
                                }  
                            }  
                            return false;  
                        },  
                        message : '身份证号码格式不正确'  
                    },  
                }); 