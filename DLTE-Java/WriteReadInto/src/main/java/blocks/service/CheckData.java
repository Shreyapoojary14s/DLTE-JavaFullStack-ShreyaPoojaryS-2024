package blocks.service;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public abstract class CheckData {
        String email;
        Long phone=0L;
        public abstract void collectPersonalData(Employee employee);
        public abstract void displayData();
        public abstract Address collectAddress(int id);
        public boolean validateEmail() {
            String emailRegex = "^[A-Za-z0-9+-_]{3,}@[A-Za-z]{3,}(.)[A-Za-z]{2,}";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return true;
            } else {
                return false;
            }
        }
        public boolean validatePhone(){
            String phoneRegex = "^[0-9]{10}";
            Pattern pattern = Pattern.compile(phoneRegex);
            Matcher matcher = pattern.matcher(phone.toString());
            if (matcher.matches()) {
                return true;

            } else {
                return false;
            }

        }



}
