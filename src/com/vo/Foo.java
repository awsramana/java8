package com.vo;

import java.util.ArrayList;
import java.util.List;

public class Foo {
	public String name;
	public List<Boo> bars = new ArrayList<>();
	public Foo(String name) {
        this.name = name;
    }
}
