package com.imooc.ad.service;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.DeleteRowsEventData;
import com.github.shyiko.mysql.binlog.event.EventData;
import com.github.shyiko.mysql.binlog.event.UpdateRowsEventData;
import com.github.shyiko.mysql.binlog.event.WriteRowsEventData;

import java.io.IOException;

/**
 * @author Jiusen Guo
 * @date 2021/2/9 18:26
 */
public class BinlogServiceTest {

    public static void main(String[] args) throws IOException {
        BinaryLogClient client = new BinaryLogClient(
                "39.97.233.41",
                3306,
                "root",
                "Gjs935219!"
        );

        client.registerEventListener(event -> {
            EventData data = event.getData();

            if (data instanceof UpdateRowsEventData) {
                System.out.println("Update-----------------");
                System.out.println(data.toString());
            } else if (data instanceof WriteRowsEventData) {
                System.out.println("Write------------------");
                System.out.println(data.toString());
            } else if (data instanceof DeleteRowsEventData) {
                System.out.println("Delete-----------------");
                System.out.println(data.toString());
            }
        });

        client.connect();
    }
}
