package org.wte;

/**
 * @author Vadym Mitin
 */
public class ReportMaker {
    public String convertDate(String date) {

        return date.replaceAll("-", ":");
    }
}
