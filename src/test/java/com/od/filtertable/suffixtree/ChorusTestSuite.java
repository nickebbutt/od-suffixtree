package com.od.filtertable.suffixtree;

import junit.framework.TestSuite;
import org.chorusbdd.chorus.ChorusJUnitRunner;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 06/05/13
 * Time: 20:08
 * To change this template use File | Settings | File Templates.
 */
public class ChorusTestSuite {

    public static TestSuite suite() {

        return ChorusJUnitRunner.suite("-f src/test/java/com/od/filtertable/suffixtree -h com.od -e");
    }
}
