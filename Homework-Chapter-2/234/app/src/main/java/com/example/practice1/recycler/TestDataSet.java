package com.example.practice1.recycler;

import java.util.ArrayList;
import java.util.List;

public class TestDataSet {

    public static List<TestData> getData() {
        List<TestData> result = new ArrayList();
        result.add(new TestData("死真的很容易吗", "524.6w"));
        result.add(new TestData("林丹退役", "433.6w"));
        result.add(new TestData("你在教我做事？", "357.8w"));
        result.add(new TestData("投身乡村教育的燃灯者", "333.6w"));
        result.add(new TestData("暑期嘉年华", "285.6w"));
        result.add(new TestData("2020年三伏天有40天", "183.2w"));
        result.add(new TestData("会跟游客合照的老虎", "139.4w"));
        result.add(new TestData("苏州暴雨", "75.6w"));
        result.add(new TestData("6月全国菜价上涨", "55w"));
        result.add(new TestData("奉天承芸好甜", "43w"));
        result.add(new TestData("IU真好看", "22.2w"));
        return result;
    }

}
