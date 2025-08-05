package com.aditya.authservice.common.regex;

public class Regex {

    public static final String email_regex = "^[a-zA-Z0-9.!#$%&*+/=?^_`{|}~-]+@[a-zA-Z0-9!#$%&*+/=?^_`{|}~-]+(.[a-zA-Z0-9!#$%&*+/=?^_`{|}~-]+)+$|^$";

    public static final String indian_mobile_regex = "^([0|+\\[0-9]{1,5})?\\s?([6-9][0-9]{9})$";

    public static final String global_mobile_regex = "^\\+?\\d{1,3}?\\s?\\d{7,}$|^$";

    public static final String pan_regex = "^[A-Za-z]{5}[0-9]{4}[A-Za-z]{1}$";

    public static final String educon_mobile_regex = "^\\+\\d{1,3}\\s\\d{7,}$|^$";
    
    public static final String gstin_regex = "^[0-9]{2}[A-Za-z]{5}[0-9]{4}[A-Za-z]{1}[0-9A-Za-z]{1}[Z]{1}[0-9A-Za-z]{1}$|^$";

    public static final String aadhaar_regex = "^[2-9]{1}\\d{3}(\\s)?\\d{4}(\\s)?\\d{4}$";

    public static final String driving_license_regex = "^(([A-Za-z]{2}[0-9]{2})|([A-Za-z]{2}-[0-9]{2}))(\\d)?((19|20)[0-9]{2})[0-9]{7}$";

    public static final String passport_regex = "^[A-Za-z][1-9]\\d{6}$";

    public static final String pincode_regex = "^[1-9]{1}[0-9]{5}$";

}
