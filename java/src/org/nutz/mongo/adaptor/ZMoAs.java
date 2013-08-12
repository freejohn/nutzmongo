package org.nutz.mongo.adaptor;

import org.nutz.lang.Lang;
import org.nutz.lang.Mirror;
import org.nutz.mongo.ZMoAdaptor;

/**
 * 各个适配器的单例工厂方法
 * 
 * @author zozoh(zozohtnt@gmail.com)
 */
public class ZMoAs {

    private static ZMoAdaptor _id = new ZMoIdAdaptor();

    private static ZMoAdaptor _array = new ZMoArrayAdaptor();

    private static ZMoAdaptor _collection = new ZMoCollectionAdaptor();

    private static ZMoAdaptor _enum = new ZMoEnumAdaptor();

    private static ZMoAdaptor _map = new ZMoMapAdaptor();

    private static ZMoAdaptor _pojo = new ZMoPojoAdaptor();

    private static ZMoAdaptor _simple = new ZMoSimpleAdaptor();

    private static ZMoAdaptor _smart = new ZMoSmartAdaptor();

    public static ZMoAdaptor get(Mirror<?> mi) {
        // 简单类型
        if (mi.isSimple()) {
            return ZMoAs.simple();
        }
        // 集合
        else if (mi.isCollection()) {
            return ZMoAs.collection();
        }
        // 数组
        else if (mi.isArray()) {
            return ZMoAs.array();
        }
        // 枚举
        else if (mi.isEnum()) {
            return ZMoAs.ENUM();
        }
        // Map
        else if (mi.isMap()) {
            return ZMoAs.map();
        }
        // POJO
        else if (mi.isPojo()) {
            return ZMoAs.pojo();
        }
        // 错误
        throw Lang.makeThrow("fail to found adaptor for type %s", mi.getType());
    }

    public static ZMoAdaptor id() {
        return _id;
    }

    public static ZMoAdaptor array() {
        return _array;
    }

    public static ZMoAdaptor collection() {
        return _collection;
    }

    public static ZMoAdaptor ENUM() {
        return _enum;
    }

    public static ZMoAdaptor map() {
        return _map;
    }

    public static ZMoAdaptor pojo() {
        return _pojo;
    }

    public static ZMoAdaptor simple() {
        return _simple;
    }

    public static ZMoAdaptor smart() {
        return _smart;
    }

}
