
import java.util.Arrays;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "pizza")
@RequestScoped
public class Pizza {
    
    private String fname,mname,lname,email,al1,al2,city,pizza_size,pizza_ing[]={""};
    private int phno,pin;
    private double final_amt;
    
    /**
     *
     * @return 
     */
    public String getFname(){ return fname;}
    public void setFname(String fname){this.fname = fname;}
    
     public String getMname(){ return mname;}
    public void setMname(String mname){this.mname = mname;}
    
     public String getLname(){ return lname;}
    public void setLname(String lname){this.lname = lname;}
    
     public String getEmail(){ return email;}
    public void setEmail(String email){this.email = email;}
    
     public String getAl1(){ return al1;}
    public void setAl1(String al1){this.al1 = al1;}
    
    public String getAl2(){ return al2;}
    public void setAl2(String al2){this.al2 = al2;}
    
    public String getCity(){ return city;}
    public void setCity(String city){this.city = city;}
    
    public String getPizza_size(){ return pizza_size;}
    public void setPizza_size(String pizza_size){this.pizza_size = pizza_size;}
    
   public String [] getPizza_ing () {return pizza_ing;}
    public void setPizza_ing (String [] pizza_ing) {this.pizza_ing = pizza_ing;}
    
    public int getPhno(){ return phno;}
    public void setPhno(int phno){this.phno = phno;}
    
    public int getPin(){ return pin;}
    public void setPin(int pin){this.pin = pin;}
    
    public String getResponse()
    {
        String response ="";

        if(pizza_size!=null)
        {   
            response+="<br>Pizza Size : "+pizza_size;
            if(Arrays.asList(pizza_size).contains("S"))
            {
                final_amt=500;
                if(Arrays.asList(pizza_ing).contains("Mushroom"))
                {
                    final_amt+=100;
                }
                if(Arrays.asList(pizza_ing).contains("Red Peppers"))
                {
                    final_amt+=100;
                }
                if(Arrays.asList(pizza_ing).contains("Green Olives"))
                {
                    final_amt+=100; 
                }
                if(Arrays.asList(pizza_ing).contains("Pineapple"))
                {
                    final_amt+=60;
                }
                if(Arrays.asList(pizza_ing).contains("Broccoli"))
                {
                    final_amt+=75;
                }
                if(Arrays.asList(pizza_ing).contains("Black Olives"))
                {
                    final_amt+=100;
                }
            }
            else if(Arrays.asList(pizza_size).contains("L"))
            {
                final_amt=1000;
                if(Arrays.asList(pizza_ing).contains("Mushroom"))
                {
                    final_amt+=150;
                }
                if(Arrays.asList(pizza_ing).contains("Red Peppers"))
                {
                    final_amt+=140;
                }
                if(Arrays.asList(pizza_ing).contains("Green Olives"))
                {
                    final_amt+=200; 
                }
                if(Arrays.asList(pizza_ing).contains("Pineapple"))
                {
                    final_amt+=120;
                }
                if(Arrays.asList(pizza_ing).contains("Broccoli"))
                {
                    final_amt+=150;
                }
                if(Arrays.asList(pizza_ing).contains("Black Olives"))
                {
                    final_amt+=200;
                }
            }
            else if(Arrays.asList(pizza_size).contains("M"))
            {
                final_amt=750;
                if(Arrays.asList(pizza_ing).contains("Mushroom"))
                {
                    final_amt+=125;
                }
                if(Arrays.asList(pizza_ing).contains("Red Peppers"))
                {
                    final_amt+=120;
                }
                if(Arrays.asList(pizza_ing).contains("Green Olives"))
                {
                    final_amt+=150; 
                }
                if(Arrays.asList(pizza_ing).contains("Pineapple"))
                {
                    final_amt+=90;
                }
                if(Arrays.asList(pizza_ing).contains("Broccoli"))
                {
                    final_amt+=125;
                }
                if(Arrays.asList(pizza_ing).contains("Black Olives"))
                {
                    final_amt+=150;
                }
            }
            else
            {
                response = "Please enter a Valid Pizza Size!";
        
            }
            
        }

        response += "<br>First Name : " +fname;
        response += "<br>Middle Name : " +mname;
        response += "<br>Last Name : " +lname;
        response += "<br>Email : " +email;
        response += "<br>Phone Number: "+phno;
        response += "<br>Address : " +al1+","+al2+","+city+" - "+pin;
        response += "<br>Total : " +final_amt;
        response += "<br>GST : 15% "+(0.15)*final_amt;
        response += "<br>Final Amt : " +(1.15*final_amt);
        return response;
    }
   
    

    public void Pizza() {
    }
    
}