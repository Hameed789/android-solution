// This code is for paper work - not runnable by android studio
/*
  QUESTION - Write a program that creates a string array of “cities”. Write a button click event. When the
  button is clicked, the currently selected value of the spinner should be shown on the screen. No
  need to write code of assigning data to spinner control.
*/

 strings.xml file code 
 
    <string-array name="cities">
        <item>Abbottabad</item>
        <item>Lahore</item>
        <item>Karachi</item>
        <item>Multan</item>
    </string-array>

 class MainActivity ... 
   
    Spinner spinner;
   
    public void onCreate(){
      
      spinner = findViewById(R.id.spinner);
      
    }// onCreate ends here 

    public void btnClick(View view){
      
      String value  = spinner.getSelectedItem().toString();
       
      // show value in toast - if required else show in textView

      // for toast
      Toast.makeText(this, value, Toast.LENGTH_SHORT).show();

      // for textview 
      TextView textView = findViewById(R.id.textView);
      textView.setText(value);
      
    }// btnClick ends here 

// ================================================================================================================ //
/*
  QUESTION - Write code to store above two rows in an ArrayList<HashMap<String, String>> list;
*/

 class MainActivity ... 
   
    ArrayList<HashMap<String, String>> list;
    HashMap<String, String> map;

    protected void onCreate() {
      
        list = new ArrayList<>();

        map = new HashMap<>();
        map.put("name","ali");
        map.put("age","23");
        list.add(map);

        map = new HashMap<>();
        map.put("name","“shazia”");
        map.put("age","22");
        list.add(map);
    }// onCreate ends here 
  
// ================================================================================================================ //
/*
  QUESTION - Write a button click event. When the button is clicked, a confirmation dialog should be shown to
  the user asking “Are you sure you want to perform this operation?” The confirmation dialog
  should have a YES and NO button. When the user clicks on YES, a message should be shown
  in a Toast: “You clicked YES”. Otherwise, the message should be shown: “You clicked NO”.
  Write the complete code of confirmation dialog.

*/




