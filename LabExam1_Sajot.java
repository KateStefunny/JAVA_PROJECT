/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.labexam1_sajot;

/**
 *
 * @author student
 */

import java.util.Scanner;
public class LabExam1_Sajot {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        System.out.println("=======ELECTRICITY BILLING STATEMENT========");
        System.out.print("Please enter your name: ");
        String name = scn.nextLine();
        System.out.print("Please enter your account number: ");
        String account_number = scn.nextLine();
        System.out.print("Please enter your previous meter reading: ");
        double previous_meter_reading = scn.nextDouble();
        System.out.print("Please enter your current meter reading: ");
        double current_meter_reading = scn.nextDouble();
        
        if (current_meter_reading<previous_meter_reading){
            System.out.print("Invalid meter reading. Please try again.");
            System.exit(0);
        }
        
        String display_customer_category = """
                                           ========================CUSTOMER CATEGORY============================    
                                           Option\t\tCustomer Category\t\tRate per kWh
                                           1\t\t\tResidential\t\tPhp 12.00
                                           2\t\t\tCommercial\t\tPhp 15.00
                                           3\t\t\tIndustrial\t\tPhp 18.00
                                           """;
                
        System.out.print(display_customer_category);
        
        System.out.print("Please enter your category: ");
        int customer_category = scn.nextInt();
        String category = "";
        double rate_per_kwh = 0;
        
        switch(customer_category){
            case 1:
                category = "Residential";
                rate_per_kwh = 12;
                break;
            case 2:
                category = "Commercial";
                rate_per_kwh = 15;
                break;
            case 3:
                category = "Industrial"; 
                rate_per_kwh = 18;
                break;
            default:
                System.out.print("Invalid Customer Category. Please try again.");
                System.exit(0);
        }
        double consumption = current_meter_reading - previous_meter_reading;
        String classification = "";
        if (consumption>500){
            classification = "Very High Consumption";
        } else if (consumption>300){
            classification = "High Consumption";
        }else if (consumption>100){
            classification = "Moderate Consumption";
        }else if (consumption>=0){
            classification = "Low Consumption";
        }else{
            System.out.println("Invalid consumption classification. Please try again.");
            System.exit(0);
        }

        String payment_display = """
                                 ========================PAYMENT METHOD========================
                                 Option\t\tPayment Method\t\tAdditional Fee
                                 1\t\tCash\t\t\tPhp 0
                                 2\t\tOnline Banking\t\tPhp 10
                                 3\t\tE-Wallet\t\tPhp 5
                                 """;
        
        System.out.print(payment_display);
        System.out.print("Please enter a payment method: ");
        int payment_option = scn.nextInt();
        String payment_method = "";
        double payment_fee = 0;
        switch (payment_option){
            case 1:
                payment_method = "Cash";
                payment_fee = 0;
                break;
            case 2:
                payment_method = "Online Banking";
                payment_fee = 10;
                break;
            case 3:
                payment_method = "E-Wallet";
                payment_fee = 5;
                break;
            default:
                System.out.print("Invalid Payment Method. Please try again.");
                System.exit(0);
        }
        
        double consumption_charge = consumption * rate_per_kwh;
        double environmental_fee = consumption_charge * 0.02;
        double total_bill = consumption_charge+environmental_fee+payment_fee;
        
        String billing_statement = String.format("""
                                                 =======ELECTRICITY BILLING STATEMENT========
                                                 Customer Name: %s
                                                 Account Number: %s
                                                 Customer Category: %s
                                                 Previous Reading: %.2f kWh
                                                 Current Reading: %.2f kWh
                                                 Consumption: %.2f kWh
                                                 Classification: %s
                                                 Rate per kWh: Php %.2f
                                                 Consumption Charge: Php %.2f
                                                 Discount: Php 0.00
                                                 Environmental Fee: Php %.2f
                                                 Payment Method: %s
                                                 Payment Fee: Php %.2f
                                                 ============================================
                                                 TOTAL AMOUNT DUE: Php %.2f
                                                 """,name,account_number,category,previous_meter_reading,current_meter_reading,consumption,classification,rate_per_kwh,
                                                 consumption_charge,environmental_fee, payment_method,payment_fee,total_bill);
        
        System.out.print(billing_statement);
        
    }
}
