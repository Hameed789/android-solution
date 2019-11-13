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

Purposes
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
/*
  QUESTION - Write a code for a button click event that load a fragment named FirstFragment and send it a
  numeric value “25”. Write the fragment code of MainActivity and the receiving code on
  Fragment, where the received number is assigned to a textView defined in Fragment layout
*/

class MainActivity ... 
  
  public void btnClick(View view) {

      FragmentManager manager = getSupportFragmentManager();
      FragmentTransaction transaction = manager.beginTransaction();

      FrameLayout frameLayout = findViewById(R.id.frame);
      frameLayout.removeAllViews();

      Fragment fragment = new FirstFragment();

      Bundle bundle = new Bundle();
      bundle.putInt("num", 25);
      fragment.setArguments(bundle);

      transaction.add(R.id.frame, fragment);

      transaction.commit();

    }

class FirstFragment ... 
  
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {

      View view = inflater.inflate(R.layout.first_fragment, container, false);

      TextView textView = view.findViewById(R.id.textView);
      int num = getArguments().getInt("num");
      textView.setText(String.valueOf(num));

      return view;
    }


// ================================================================================================================ //
/*
  QUESTION - Write the purpose of fragments and write code of passing a string value “Pakistan” from
  MainActivity to a fragment. Write also code in fragment that should concatenate “ Zindabad”
  with Pakistan and return the whole string. In the MainActivity, the final string “Pakistan
  Zindabad” should be received.
*/

Purposes
--- A fragment has its own layout and its own behaviour with its own life cycle callbacks.
--- You can add or remove fragments in an activity while the activity is running.
--- You can combine multiple fragments in a single activity to build a multi-pane UI.
--- A fragment can be used in multiple activities.
--- A fragment can implement a behaviour that has no user interface component.


class MainActivity ... 
  
    public void onCreate(Bundle savedInstanceState) {

        if (getIntent() != null && getIntent().getExtras() != null) {
            String value = getIntent().getExtras().getString("value");
            TextView textView = findViewById(R.id.textView);
            textView.setText("Value received : " + value);
        }

    }// onCreate ends here 

    public void btnClick(View vew) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        FrameLayout frameLayout = findViewById(R.id.frame);
        frameLayout.removeAllViews();

        Fragment fragment = new FirstFragment();

        Bundle bundle = new Bundle();
        bundle.putString("value", "Pakistan");
        fragment.setArguments(bundle);

        transaction.add(R.id.frame, fragment);

        transaction.commit();

     }// btnClick ends here 


class FirstFragment ... 

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {

        View view = inflater.inflate(R.layout.first_fragment, container, false);

        String value = getArguments().getString("value");
        value += " Zindabad";

        Intent intent = new Intent(getContext(), MainActivity.class);
        intent.putExtra("value", value);
        getContext().startActivity(intent);

        return view;
    }


// ================================================================================================================ //
/*
  QUESTION - Create an application in which the MainActivity passes an ID to a Fragment. The fragment
  fetches the record of a user from SQLite database and loads it into TextViews defined in
  Fragment’s layout file.
*/


class MainActivity ... 
  
   public void btnClick(View vew) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        FrameLayout frameLayout = findViewById(R.id.frame);
        frameLayout.removeAllViews();

        Fragment fragment = new FirstFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("ID", 10);
        fragment.setArguments(bundle);

        transaction.add(R.id.frame, fragment);

        transaction.commit();

    }// btnClick ends here


class FirstFragment ... 
  
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {

        View view = inflater.inflate(R.layout.first_fragment, container, false);

        int ID = getArguments().getInt("ID");

        TextView name = view.findViewById(R.id.name);
        TextView email = view.findViewById(R.id.email);

        SQLiteDatabase db = databaseObject.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from students where ID = ?", new String[]{String.valueOf(ID)});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            name.setText(cursor.getString(1));
            email.setText(cursor.getString(2));
        } else {
            Toast.makeText(getContext(), "Record not found", Toast.LENGTH_SHORT).show();
        }

        return view;
    }

// ================================================================================================================ //
/*
  QUESTION - Write a method that deletes the row from database whose id is 25.
*/

class MainActivity ... 
  
  public void btnClick(View vew) {

        EditText editText = findViewById(R.id.editText);
        String value = editText.getText().toString().trim();

        if (value.isEmpty()) {
            Toast.makeText(this, "Please enter value", Toast.LENGTH_SHORT).show();
        } else {
            try {
                int ID = Integer.parseInt(value);
                SQLiteDatabase db = databaseObject.getWritableDatabase();
                db.delete("student", " id = " + ID, null);
                db.close();
            } catch (Exception e) {
                Toast.makeText(this, "Please enter numeric value only", Toast.LENGTH_SHORT).show();
            }// try - catch ends here 

        } // else ends here 

   }// btnClick ends here


// ================================================================================================================ //
/*
  QUESTION - Write a method that inserts value in database.
*/

class MainActivity ... 
  
   public void btnClick(View vew) {

        EditText id_edit_text = findViewById(R.id.id_edit_text);
        EditText name_edit_text = findViewById(R.id.name_edit_text);
        EditText address_edit_text = findViewById(R.id.address_edit_text);

        String str_id = id_edit_text.getText().toString().trim();
        String str_name = name_edit_text.getText().toString().trim();
        String str_address = address_edit_text.getText().toString().trim();
        Integer ID = null;

        if (str_id.isEmpty() || str_name.isEmpty() || str_address.isEmpty()) {
            Toast.makeText(this, "Please enter all value", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            ID = Integer.parseInt(str_id);
        } catch (Exception e) {
            Toast.makeText(this, "Please enter proper ID value", Toast.LENGTH_SHORT).show();
        }

        SQLiteDatabase db = databaseObj.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("ID", ID);
        values.put("name", str_name);
        values.put("address", str_address);

        db.insertOrThrow("students", null, values);

    }// btnClick ends here


// ================================================================================================================ //
/*
  QUESTION - For the layout given in above form, write code for update operation
*/

class MainActivity ... 
  
  public void btnClick(View vew) {

        EditText id_edit_text = findViewById(R.id.id_edit_text);
        EditText name_edit_text = findViewById(R.id.name_edit_text);
        EditText address_edit_text = findViewById(R.id.address_edit_text);

        String str_id = id_edit_text.getText().toString().trim();
        String str_name = name_edit_text.getText().toString().trim();
        String str_address = address_edit_text.getText().toString().trim();
        Integer ID = null;

        if (str_id.isEmpty() || str_name.isEmpty() || str_address.isEmpty()) {
            Toast.makeText(this, "Please enter all value", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            ID = Integer.parseInt(str_id);
        } catch (Exception e) {
            Toast.makeText(this, "Please enter proper ID value", Toast.LENGTH_SHORT).show();
        }

        SQLiteDatabase db = databaseObj.getWritableDatabase();
        ContentValues values = new ContentValues();
        
        values.put("name", str_name);
        values.put("address", str_address);

        db.update("students", values, " ID = " + ID, null);

    }// btnClick ends here

// ================================================================================================================ //
/*
  QUESTION - Suppose we have the search form as shown above. Write code to make a dynamic select
  query. You just need to create the query and nothing else.
*/

class MainActivity ... 
  
  public void btnClick(View vew) {

        String query = "select * from students where ";
        ArrayList<String> temp = new ArrayList<>();

        EditText id_edit_text = findViewById(R.id.id_edit_text);
        EditText name_edit_text = findViewById(R.id.name_edit_text);
        EditText address_edit_text = findViewById(R.id.address_edit_text);

        String str_id = id_edit_text.getText().toString().trim();
        String str_name = name_edit_text.getText().toString().trim();
        String str_address = address_edit_text.getText().toString().trim();


        if (!str_id.isEmpty()) {
            // ID is not empty
            temp.add(" ID = " + str_id);
        }

        if (!str_name.isEmpty()) {
            temp.add("name like ' % " + str_name + " % ' ");
        }

        if (!str_address.isEmpty()) {
            temp.add("address like ' % " + str_address + " % ' ");
        }


        for (int i = 0; i < temp.size(); i++) {

            if (i == (temp.size() - 1)) {
                // last record - we do not need and in the last
                query += temp.get(i);
                
            } else {

                query += temp.get(i) + " and ";
            } // if - else ends here

        }// for loop ends here 

   }// btnClick ends here

// ================================================================================================================ //
/*
  QUESTION - Write an application that asks for an ID from user in Record Search Activity. When the user
  enters the ID, the record is shown against the ID in the Record View Activity. The record is
  fetched from SQLite Database.
*/


 class RecordSearchActivity ... 

 public void btnClick(View vew) {

        EditText id_edit_text = findViewById(R.id.id_edit_text);
        String str_id = id_edit_text.getText().toString().trim();

        if (str_id.isEmpty()) {
            Toast.makeText(this, "Please enter ID value", Toast.LENGTH_SHORT).show();
        } else {
            try {

                Integer.parseInt(str_id); // checking if ID is valid or not 

                SQLiteDatabase db = databaseObject.getReadableDatabase();
                Cursor cursor = db.rawQuery("select * from students where ID = ?", new String[]{ str_id });
                if (cursor.getCount() > 0) {
                    cursor.moveToFirst();

                    Intent intent = new Intent(this, ViewRecordActivity.class);
                    intent.putExtra("ID", cursor.getInt(0));
                    intent.putExtra("name", cursor.getString(1));
                    intent.putExtra("age", cursor.getInt(2));
                    intent.putExtra("address", cursor.getString(3));
                    startActivity(intent);

                } else {
                    Toast.makeText(this, "Record not found", Toast.LENGTH_SHORT).show();
                }

            } catch (Exception e) {
                Toast.makeText(this, "Please enter proper ID value", Toast.LENGTH_SHORT).show();
            } // try - catch ends here

        } // if - else ends here

    }// btnClick ends here


class ViewRecordActivity ... 

  public void onCreate(Bundle savedInstanceState) {
      
      TextView id_text_view = findViewById(R.id.id_text_view);
      TextView name_text_view = findViewById(R.id.name_text_view);
      TextView address_text_view = findViewById(R.id.address_text_view);
      TextView age_text_view = findViewById(R.id.age_text_view);

      id_text_view.setText( String.valueOf( getIntent().getExtras().getInt("ID") ) );
      name_text_view.setText( getIntent().getExtras().getString("name") );
      address_text_view.setText( getIntent().getExtras().getString("address") );
      age_text_view.setText( String.valueOf( getIntent().getExtras().getInt("age") ) );

    }

// ================================================================================================================ //
/*
  QUESTION - Write a method that update value in database against ID = 25
*/

class MainActivity ... 
  
  public void btnClick(View vew) {

        EditText id_edit_text = findViewById(R.id.id_edit_text);
        EditText name_edit_text = findViewById(R.id.name_edit_text);
        EditText address_edit_text = findViewById(R.id.address_edit_text);

        String str_id = id_edit_text.getText().toString().trim();
        String str_name = name_edit_text.getText().toString().trim();
        String str_address = address_edit_text.getText().toString().trim();
        Integer ID = null;

        if (str_id.isEmpty() || str_name.isEmpty() || str_address.isEmpty()) {
            Toast.makeText(this, "Please enter all value", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            ID = Integer.parseInt(str_id);
        } catch (Exception e) {
            Toast.makeText(this, "Please enter proper ID value", Toast.LENGTH_SHORT).show();
        }

        SQLiteDatabase db = databaseObj.getWritableDatabase();
        ContentValues values = new ContentValues();
        
        values.put("name", str_name);
        values.put("address", str_address);

        db.update("students", values, " ID = " + ID, null);

    }// btnClick ends here



// ================================================================================================================ //





























