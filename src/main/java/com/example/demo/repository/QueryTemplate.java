package com.example.demo.repository;

public class QueryTemplate {

    public static String accountsViewQuery(Long customerId){
        return "SELECT UNIQUE_NO AS accountNo, NAME as accountName, " +
                "BUSINESS_NAME as accountType, now() as balanceDate, ISO_CODE as currency, " +
                "OPENING_BALANCE as openingBalance FROM ACCOUNT A, ACCOUNT_TYPE ACCTYPE, " +
                "CURRENCY C where  A.CUSTOMER_ID="+customerId+" AND A.TYPE=ACCTYPE.ID AND A.CURRENCY=C.ID";
    }

    public static String accountsTransactionViewQuery(Long accountId){
        return  "SELECT UNIQUE_NO as accountNo, A.NAME as accountName, TRANSACTION_DATE as " +
                "valueDate, ISO_CODE as currency,  TYP.NAME as debitOrCredit, " +
                "case WHEN TYP.NAME='CREDIT' " +
                "THEN TRANSACTION_VALUE END as creditAmount, " +
                "case WHEN TYP.NAME='DEBIT' THEN TRANSACTION_VALUE END as debitAmount " +
                " FROM  ACCOUNT A, ACCOUNT_TRANSACTION TRX,  TRANSACTION_TYPE TYP, CURRENCY " +
                " WHERE A.ID=TRX.ACCOUNT_ID AND TRX.TYPE=TYP.ID AND A.CURRENCY=CURRENCY.ID  " +
                " AND  A.ID="+accountId;
    }

}
