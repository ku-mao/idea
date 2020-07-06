package edu.nowcoder;

import java.util.*;


public class 简单错误记录 {
    static class Record {
        int count;
        String info;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Record> list = new ArrayList<Record>();
        while (sc.hasNext()) {
            String way = sc.nextLine();
            int index = way.lastIndexOf("\\");
            String info  = way.substring(index + 1);
            int tmp = find(list, info);
            if (tmp != -1) {
                list.get(tmp).count++;
            } else {
                Record newRecord = new Record();
                newRecord.info = info;
                newRecord.count = 1;
                list.add(newRecord);
            }
        }
        Record[] records = list.toArray(new Record[list.size()]);
        insertSort(records);
        print(records);
    }



    private static int find(List<Record> list, String info) {
        for (int i = 0; i < list.size(); i++) {
            if (info.equals(list.get(i).info)) {
                return i;
            }
        }
        return -1;
    }
    private static void insertSort(Record[] records) {
        int j = 0;
        for (int i = 1; i < records.length; i++) {//待排
            Record tmp = records[i];
            for (j = i; j > 0 && (tmp.count > records[j - 1].count); j--) {
                records[j] = records[j - 1];
            }
            records[j] = tmp;
        }
    }
    private static void print(Record[] records) {
        int len = records.length > 8 ? 8 : records.length;
        for (int i = 0; i < len; i++) {
            String[] s = records[i].info.split(" ");
            int index = s[0].length() - 16;
            if (index > 0) {
                System.out.println(s[0].substring(index) + " " + s[1] + " " + records[i].count);
            } else {
                System.out.println(records[i].info + " " + records[i].count);
            }
        }
    }
}
