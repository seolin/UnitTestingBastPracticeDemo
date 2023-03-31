package com.simple.testing.infrasturcture.init;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author chenkangkang
 * @date 2022/1/24 5:26 PM
 **/
@Component
public class InitDatabase {
    @Resource
    private DataSource datasource;


    @PostConstruct
    public void init() throws SQLException {
        Connection conn = datasource.getConnection();
        final Statement createFolder = conn.createStatement();
        String createOrderTable = "CREATE TABLE IF NOT EXISTS \n" +
                "T_ORDER(\n" +
                "    id BIGINT IDENTITY PRIMARY KEY,  \n" +
                "    buyer_id BIGINT NOT NULL,\n" +
                "    buyer_name VARCHAR(512) ,  \n" +
                "    seller_id BIGINT NOT NULL,\n" +
                "    seller_name VARCHAR(512) ,  \n" +
                "    good_title VARCHAR(512) NOT NULL,\n" +
                "    price VARCHAR(512) NOT NULL,\n" +
                "    create_time TIMESTAMP NOT NULL,\n" +
                "    update_time TIMESTAMP NOT NULL\n" +
                "    )";
        createFolder.execute(createOrderTable);
        createFolder.close();

        // 为数据库生成索引
        final Statement createFileNameIndex = conn.createStatement();
        createFileNameIndex.execute("CREATE INDEX IF NOT EXISTS buyer_id_index ON T_ORDER (buyer_id)");
        createFileNameIndex.execute("CREATE INDEX IF NOT EXISTS seller_id_index ON T_ORDER (seller_id)");
        createFileNameIndex.execute("CREATE INDEX IF NOT EXISTS good_title_index ON T_ORDER (good_title)");
        createFileNameIndex.close();

    }

}
