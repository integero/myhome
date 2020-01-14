package ru.epam.homework.aa_sax;

import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

public abstract class  MyDefHandler <P> extends DefaultHandler {
    public abstract List<P> getList();
}
