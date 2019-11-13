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

    public void onCreate() {
      
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

class MainActivity ... 
  
  public void btnClick(View view){
  
    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
  
    builder.setMessage("Are you sure you want to perform this operation?");
  
    builder.setPositiveButton("YES", ... {
        public void onClick(...) {
            Toast.makeText(MainActivity.this, "You clicked YES", Toast.LENGTH_SHORT).show();
        }
    });
  
    builder.setNegativeButton("NO", ... {
        public void onClick(...) {
            Toast.makeText(MainActivity.this, "You clicked NO", Toast.LENGTH_SHORT).show();
        }
    });

    AlertDialog dialog = builder.create();
    dialog.show();
  
  }// btnClick ends here 

// ================================================================================================================ //

/*
  QUESTION - Write the purpose of fragments and write code of passing a string value “Pakistan” from
  MainActivity to a fragment.
*/

--- A fragment has its own layout and its own behaviour with its own life cycle callbacks.
--- You can add or remove fragments in an activity while the activity is running.
--- You can combine multiple fragments in a single activity to build a multi-pane UI.
--- A fragment can be used in multiple activities.
--- A fragment can implement a behaviour that has no user interface component.


 class MainActivity ... 
    
   public void btnClick(View view) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        FrameLayout frameLayout = findViewById(R.id.frame);
        frameLayout.removeAllViews();

        Fragment fragment = new HomeFragment();

        Bundle bundle = new Bundle();
        bundle.putString("country", "Pakistan");
        fragment.setArguments(bundle);

        transaction.add(R.id.frame, fragment);

        transaction.commit();

    }

// ================================================================================================================ //




