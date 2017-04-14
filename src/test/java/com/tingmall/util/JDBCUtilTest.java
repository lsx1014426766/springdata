package com.tingmall.util;

import junit.framework.Assert;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by lsx on 2017/4/13.
 */
public class JDBCUtilTest {
    @Test
    public void testGetConnection() throws Exception {
        Connection conn=JDBCUtil.getConnection();
        Assert.assertNotNull(conn);

    }

}
