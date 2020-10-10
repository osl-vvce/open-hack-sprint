package com.example.notesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    public static final String EXTRA_ID="package com.example.notesapp.EXTRA_ID";
    public static final String EXTRA_TITLE="package com.example.notesapp.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION="package com.example.notesapp.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY="package com.example.notesapp.EXTRA_PRIORITY";

    EditText etTitle,etDescription;
    NumberPicker numberPicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etTitle=findViewById(R.id.etTitle);
        etDescription=findViewById(R.id.etDescription);
        numberPicker=findViewById(R.id.numberPicker);

        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(50);

        //for close page in action bar.
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close);

        Intent intent=getIntent();
        if(intent.hasExtra(EXTRA_ID))
        {
            setTitle("Edit Note");
            etTitle.setText(intent.getStringExtra(EXTRA_TITLE));
            etDescription.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            numberPicker.setValue(intent.getIntExtra(EXTRA_PRIORITY,1));
        }
        else
        {
            setTitle("Add Note");
        }
    }

    //to enable menu option.

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.saveNote: saveNote();
            return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveNote()
    {
        String title=etTitle.getText().toString();
        String description=etDescription.getText().toString();
        int priority=numberPicker.getValue();

        if(title.trim().isEmpty() || description.trim().isEmpty())
        {
            Toast.makeText(this, "Please enter a title and description", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent=new Intent();
        intent.putExtra(EXTRA_TITLE,title);
        intent.putExtra(EXTRA_DESCRIPTION,description);
        intent.putExtra(EXTRA_PRIORITY,priority);

        int id=getIntent().getIntExtra(EXTRA_ID,-1);
        if(id!=-1)
        {
            intent.putExtra(EXTRA_ID,id);
        }

        setResult(RESULT_OK,intent);
        finish();
    }
}