/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.parsing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Clinton Begin
 * 通用标记解析器: 需要一个标记处理器实现类
 *  对sql中传递的#{}、${}进行替换
 */
public class GenericTokenParser {

    /** 开始标记,比如: #{ 、 ${ */
    private final String openToken;
    /** 结束标记, 比如: } */
    private final String closeToken;
    /** 标记处理器, 比如: 根据 #{name}、${name} 得到 name的值 */
    private final TokenHandler handler;

    public GenericTokenParser(String openToken, String closeToken, TokenHandler handler) {
        this.openToken = openToken;
        this.closeToken = closeToken;
        this.handler = handler;
    }

    public String parse(String text) {
        /** 结果集 */
        final StringBuilder builder = new StringBuilder();
        /** 表达式 */
        final StringBuilder expression = new StringBuilder();
        if (text != null && text.length() > 0) {
            char[] src = text.toCharArray();
            int offset = 0;
            /** search 开始标记的位置 */
            int start = text.indexOf(openToken, offset);
            while (start > -1) {
                /** 在开始标记前存在转义符号,不解析 */
                if (start > 0 && src[start - 1] == '\\') {
                    // this open token is escaped. remove the backslash and continue.
                    builder.append(src, offset, start - offset - 1).append(openToken);
                    offset = start + openToken.length();
                } else {
                    /** 不存在转义符号 */
                    // found open token. let's search close token.
                    expression.setLength(0);
                    builder.append(src, offset, start - offset);
                    offset = start + openToken.length();
                    /** search 结束标记的位置 */
                    int end = text.indexOf(closeToken, offset);
                    while (end > -1) {
                        /** 在结束标记前存在转义符号 */
                        if (end > offset && src[end - 1] == '\\') {
                            // this close token is escaped. remove the backslash and continue.
                            expression.append(src, offset, end - offset - 1).append(closeToken);
                            offset = end + closeToken.length();
                            end = text.indexOf(closeToken, offset);
                        } else {
                            /** 将表达式括起来的变量存储起来 */
                            expression.append(src, offset, end - offset);
                            offset = end + closeToken.length();
                            break;
                        }
                    }
                    /** 找了一遍,未找到结束标记 */
                    if (end == -1) {
                        // close token was not found.
                        builder.append(src, start, src.length - start);
                        offset = src.length;
                    } else {
                        /** 处理表达式中括起来的token */
                        builder.append(handler.handleToken(expression.toString()));
                        offset = end + closeToken.length();
                    }
                }
                start = text.indexOf(openToken, offset);
            }
            if (offset < src.length) {
                builder.append(src, offset, src.length - offset);
            }
        }
        return builder.toString();
    }

    public static class MyTokenHandler implements TokenHandler {

        private Map<String, String> content;

        public MyTokenHandler(Map<String, String> content) {
            this.content = content;
        }

        @Override
        public String handleToken(String content) {
            return this.content.get(content);
        }
    }

    public static void main(String[] args) {
        GenericTokenParser parser = new GenericTokenParser("${", "}",
                new MyTokenHandler(new HashMap<String, String>(){
                    {
                        put("first_name","Foo");
                        put("last_name", "Bar");
                    }
        }));

        String parse = parser.parse("${first_name}   -  ${last_name}");
        System.out.println(parse);

        String parse1 = parser.parse("${first_name} - ${last_name");
        System.out.println(parse1);

        String parse2 = parser.parse("${first_name} - \\${last_name}");
        System.out.println(parse2);

    }

}
