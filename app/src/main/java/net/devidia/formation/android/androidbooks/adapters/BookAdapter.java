package net.devidia.formation.android.androidbooks.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.devidia.formation.android.androidbooks.R;
import net.devidia.formation.android.androidbooks.models.Book;

import java.util.List;

/**
 * Created by Boris on 12/05/2016.
 */
public class BookAdapter extends ArrayAdapter<Book> {
    public BookAdapter(Context context, int resource, List<Book> objects) {
        super(context, resource, objects);
    }
    // On récupère le constructeur qui nous permet d'initialiser le ArrayAdapter avec une List (ex: ArrayList<Book>)


    // Le Array Adatper permet de convertir des objets JAVA, dans leur représentation graphique dans une list view
    // cela se fait grâce à getView()
    // on redéfinit notre propre getView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // récupérer l'objet Book à l'index position
        Book book = getItem(position);

        // vérifier si l'objet View, ici convertView est bien initialisé
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_book, parent, false);
        }

        // affecter les données à la vue
        // dans un premier temps, récupérer les composants de la vue
        ImageView imgV = (ImageView) convertView.findViewById(R.id.bookListImageView);
        TextView title = (TextView) convertView.findViewById(R.id.bookListTitle);
        TextView author = (TextView) convertView.findViewById(R.id.bookListAuthor);

        // assigner les valeurs
        title.setText(book.getTitle());
        author.setText(book.getAuthor());

        // pour assigner l'image nous utilisons la librairie Picasso
        //Picasso.with(getContext()).load(book.getCoverUrl()).into(imgV);
        Picasso.with(getContext()).load(Uri.parse(book.getCoverUrl())).error(R.drawable.default_image).into(imgV);


        // on renvoie la ligne avec les bonnes données
        return convertView;
    }
}
