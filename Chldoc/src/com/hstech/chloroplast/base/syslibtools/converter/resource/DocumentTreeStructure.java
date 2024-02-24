package com.hstech.chloroplast.base.syslibtools.converter.resource;

public class DocumentTreeStructure {
    enum Kind{
        DESCRIPTION("描述"),
        AUTHOR("作者"),TARGET("函数实现目标"),SINCE("于该项目的起始存在版本"),
        SUPERCLASS("超类清单"), INTERNALCLASS("内部类清单"),CHILDCLASS("子类清单"),
        EXCEPTION("异常类型清单");

        public final String tagName;
        Kind() {
            tagName = null;
        }

        Kind(String tagName) {
            this.tagName = tagName;
        }
    }

}
