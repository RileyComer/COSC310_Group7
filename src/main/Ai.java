package main;

public class Ai {
  	private String out;
  	private String[] data;
  
  	//KEYWORDS
  	private String[] greetings={
            	"hi",
            	"hello", 
            	"good morning",
            	"good afternoon",
            	"howdy"
            };
  
  	private String[] food={
            	"order",
            	"food",
			"meal",
            };
  
  	private String[] gratitude={
            	"thank",
            	"thank you", 
            	"thx",
            	"thnx",
              	"thankyou"
      };
  	private String[] money={
      	"money",
        	"transaction",
        	"charge"
      };
  	private String[] person={
        "person",
        "representative",
        "agent"
      };
  

	
	public Ai() {   
      	data=new String[10];
        
		// DATA  of the order
        	data[0]="Muhammad McLovin";//drivers name
        	data[1]="McWendy's";//Food location
        	data[2]="911-XXX-XXXX";//Store number;
        	data[3]="Not at your location";//Driver Location
            data[4]="9X0 X69";//Drivers license plate number
        	data[5]="$15.99";//Amount Charged
        	data[6]="$2.00";//tip
        	data[7]="3192 Lower Residence Lane";//Address
        	data[8]="8";//referral number
        	data[9]="$3.25";//giftcard balance
  
	}
	public String getResponse(String input) {
        /*
		Purpose: takes a users input and corresponds with an appropriate response
		Input: input, A String that takes user input
		Output: output, A String that takes
         */
        	input=cleanInput(input);
       	out ="";     
        	boolean isOutput=false;
        	if(input.contains("exit")){
            	return "exiting";
            }
        	
        	for(int i=0; i< greetings.length; i++){
            	if(input.contains(greetings[i])){
                  	out+=(greetings[(int)(Math.random()*greetings.length)])+", ";
                  }
      	}
  
  		if(input.contains("where")){
              	for(int i=0; i< food.length; i++){
                  	if((input.contains(food[i]) || input.contains("driver") )&& (input.contains("going")||input.contains("headed"))){
                        	out+=("Your order is headed to " + data[7] + ".");
                          	isOutput=true;
                          	break;
                  	}else if(input.contains(food[i]) && input.contains("from")){
                        	out+=("Your order is from " + data[1] + ".");
                          	isOutput=true;
                          	break;
                        } else if(input.contains(food[i]) || input.contains("driver")){
                        	out+=("Your order is currently at " + data[3] + ".");
                          	isOutput=true;
                          	break;
                        }
                  }
            }else if(input.contains("what")){
              	if(input.contains("number")){
                    	if(input.contains("driver")){
                  		if(input.contains("license") || input.contains("plate") || input.contains("car")){
                        		out+=("The driver's license plate number is" + data[4]);
                                	isOutput=true;
                        	}else if(input.contains("phone")){
                        		out+=("We cannot disclose the information.");
                                	isOutput=true;
                        	}
                        }else if(input.contains("store")){
                        	out+=("The store number is " + data[2] + ".");
                          	isOutput=true;
                        }
                  }else if(input.contains("driver") && (input.contains("car") || input.contains("vehical") || input.contains("driving"))){
                  	out+=("They are driving a blue truck");
                        isOutput=true;
                  }else if(input.contains("referral")){
                    	if(input.contains("code")){
                          	out+=("Your code is S74SJF");
                          	isOutput=true;
                        }else if(input.contains("uses") || input.contains("count")){
                          	out+=("You have referral count of " + data[8] + ".");
                          	isOutput=true;
                        }
                  }
            }else if(input.contains("when")){
            	for(int i=0; i<food.length; i++) {
            		if(input.contains(food[i]) || input.contains("driver")){
                        	out+="Your food will be coming shortly";
                        	isOutput=true;
                          	break;
                     	}
            	}
      	}else if(input.contains("how")){
              	if(input.contains("tip") && input.contains("should")){
                    	out+=("Your driver takes 100% of the delivery fee and tip. It depends on how much you would like to tip.");
                    	isOutput=true;
                  }else if(input.contains("tip")){
                    	out+=("You tipped your driver " + data[6] + ".");
                    	isOutput=true;
                  }else if(input.contains("far")){
                    	out+=("We deliver in 10km radius of the store, The delivery fee differs depending on the location.");
                        isOutput=true;
                  }else{
                    	for (int i = 0; i<money.length; i++){
                    		if(input.contains(money[i])){
                          		out+=("The amount charged for your most recent order was " + data[5] + ".");
                          		isOutput=true;
                                	break;
                    		}	
              		}
                  }
            }
        	if (input.contains("number")){
              	if(input.contains("how") || input.contains("where")){
                    	if(input.contains("change")){
                          	out+=("In the settings, you can press the change info button to change your phone number.");
                              isOutput=true;
                        }
                  }
            }else if (input.contains("who")){
            	if(input.contains("driver")){
                  	out+=("Your driver's name is "+data[0]);
                    	isOutput=true;
                  }if(input.contains("you")){
                  	out+=("I am a chat bot built to answer your questions");
                    	isOutput=true;
                  }
            }else if(input.contains("human") || input.contains("person") || input.contains("agent") || input.contains("representative")){
            	if(input.contains("talk") || input.contains("speak") || input.contains("ask")){
                  	out+=("I have sent your request to one of our representatives. They will be in contact shortly.");
                    	isOutput=true;
                  }
            }else if(input.contains("forgot")){
                	if(input.contains("password")){
                    	out+=("You can use our website to change your password by clicking FORGOT PASSWORD");
                    	isOutput=true;
                  }else if(input.contains("username")){
                    	out+=("We have sent you an email to inform you of your username.");
                    	isOutput=true;
                  }
            }
        	if(input.contains("apply") || input.contains("business")){ 
            	if(input.contains("hire") || input.contains("become a driver")){
              		out+=("You can apply for a position in our YeetTheDishes team here! https://google.com");
              		isOutput=true;
                  }else if(input.contains("my")){
                  	if(input.contains("restaurant") || input.contains("local") || input.contains("family restaurant") || input.contains("family business")){
                  		out+=("Of course! We support local business, If you are looking to add your business to our listing, reach out to us at https://google.com");
                          	isOutput=true;
                    	}
                  }
            }
        	if(input.contains("rate")){
              	if(input.contains("restaurant") || (input.contains("store"))){
                    	out+=("You can rate the restaurant you just ordered from here!");
                    	isOutput=true;
                  }else if(input.contains("driver")){
                        out=("You can rate the driver here!");
                        isOutput=true;
                  }
            }else if(input.contains("contactless")){
        		out+=("Contactless delivery is available!");
                  isOutput=true;
      	}else if(input.contains("gift")){
        		if(input.contains("get") || input.contains("purchase")){
                  	out+=("You are able to purchase a gift card for your loved ones at https://google.com");
                    	isOutput=true;
                  }else if(input.contains("use") || (input.contains("spend"))){
                    	out+=("Make sure you put in the code of your gift card in the transaction page of your order to use your gift card.");
                    	isOutput=true;
                  }else if(input.contains("have") || (input.contains("left"))){
                  	out+=("You currently have " + data[9] + " left on your gift card.");
                    	isOutput=true;
                  }
      	}
  
  		if(input.contains("help")){
              	out+=("If you require any furthur assistance, feel free to reach out at https://google.com");
              	isOutput=true;
            }
  		
		if(!isOutput){
            	out="Sorry I don't understand your question.";
            }
		return out;	
      }
  
  	private String cleanInput(String input){
        	String out=input.toLowerCase();
      	return out;
      }

}