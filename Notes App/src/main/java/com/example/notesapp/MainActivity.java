package com.example.notesapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE=1;
    public static final int EDIT_REQUEST_CODE=2;

    FloatingActionButton addBtn;
    private NoteViewModel noteViewModel;      //fetches from view model.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBtn=findViewById(R.id.AddBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final NoteAdapter adapter=new NoteAdapter();
        recyclerView.setAdapter(adapter);

        noteViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                adapter.setNotes(notes);
            }
        });

        //to swipe and delete.
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                noteViewModel.delete(adapter.getNoteAt(viewHolder.getAdapterPosition()));
            }
        }).attachToRecyclerView(recyclerView);

        adapter.setOnClickedListener(new NoteAdapter.onItemClickedListener() {
            @Override
            public void onClicked(Note note) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra(MainActivity2.EXTRA_TITLE,note.getTitle());
                intent.putExtra(MainActivity2.EXTRA_DESCRIPTION,note.getDescription());
                intent.putExtra(MainActivity2.EXTRA_PRIORITY,note.getPriority());
                intent.putExtra(MainActivity2.EXTRA_ID,note.getId());
                startActivityForResult(intent,EDIT_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK)
        {
            String title=data.getStringExtra(MainActivity2.EXTRA_TITLE);
            String description=data.getStringExtra(MainActivity2.EXTRA_DESCRIPTION);
            int priority=data.getIntExtra(MainActivity2.EXTRA_PRIORITY,1);

            Note note=new Note(title,description,priority);
            noteViewModel.insert(note);

            Toast.makeText(this, "Note Saved!", Toast.LENGTH_SHORT).show();
        }
        else if(requestCode==EDIT_REQUEST_CODE && resultCode==RESULT_OK)
        {
            int id=data.getIntExtra(MainActivity2.EXTRA_ID,-1);
            if(id==-1)
            {
                Toast.makeText(this, "Note cannot be updated", Toast.LENGTH_SHORT).show();
            }
            else
            {
                String title=data.getStringExtra(MainActivity2.EXTRA_TITLE);
                String description=data.getStringExtra(MainActivity2.EXTRA_DESCRIPTION);
                int priority=data.getIntExtra(MainActivity2.EXTRA_PRIORITY,1);

                Note note=new Note(title,description,priority);
                note.setId(id);
                noteViewModel.update(note);
                Toast.makeText(this, "Note updated!", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Note not saved", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.deleteAllNotes:
                noteViewModel.deleteAllNotes();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}