package com.mateovelazco.projekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<SlideModel> imageList = new ArrayList<>();//create image list
    private ImageSlider imageSlider;

    private ArrayList<Product> listProducts = new ArrayList<>();
    private RecyclerView rvProductsMain;
    private Toolbar topAppBar;
    private ImageView btni_productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFakeData();


        rvProductsMain = findViewById(R.id.rv_products_main);

        ProductAdapter myAdapter = new ProductAdapter(listProducts);
        rvProductsMain.setAdapter(myAdapter);


        StaggeredGridLayoutManager myStagger = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        GridLayoutManager myGrid = new GridLayoutManager(getApplicationContext(), 2);
        LinearLayoutManager myLinear = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvProductsMain.setLayoutManager(myStagger);

        imageSlider = findViewById(R.id.image_slider_home);

        imageList.add(new SlideModel("https://www.opticaico.com/imagenes/10092020/bannerestilodevida.jpg", ScaleTypes.FIT));
        imageList.add(new SlideModel("https://www.lentesplus.com/media/wysiwyg/home/banner-3-co.jpg", ScaleTypes.FIT));
        imageList.add(new SlideModel("https://www.opticaciscar.com/wp-content/uploads/2022/07/8963306f0f22340263f24205bbee4c5fcb87fc85.png", ScaleTypes.FIT));

        imageSlider.setImageList(imageList);

        // Encontrar el ImageView por su ID
        btni_productos = findViewById(R.id.btni_productos);
        // Configurar el OnClickListener
        btni_productos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent para iniciar la FormProductActivity
                Intent intent = new Intent(MainActivity.this, Formulas.class);
                startActivity(intent);
            }
        });
    }

    private void loadFakeData() {
        Product product1 = new Product("Gafas Ray Band", "Edicion 22", 120.000, "https://assets.lenscrafters.com/is/image/LensCrafters/8056597935562__001.png");
        Product product2 = new Product("Gafas de Moda", "Modelo achatado", 30.000, "https://www.lentesplus.com/media/catalog/product/g/a/gafas_de_filtro_azul_-_bright_black.jpg?auto=webp&format=pjpg&width=640&height=800&fit=cover");
        Product product3 = new Product("Gafas Carolina", "Color rosa", 70.000, "https://m.media-amazon.com/images/I/51R9ebjdSHS._AC_SL1500_.jpg");
        Product product4 = new Product("Gafas Prada", "Color marron", 120.000, "https://assets2.sunglasshut.com/cdn-record-files-pi/a9a47ff0-2772-4f30-862b-add700016a84/d2ca2948-69b9-499f-9479-add700017288/0PR_22YS__1AB05Q__STD__noshad__qt.png?impolicy=SGH_bgtransparent&width=640");
        Product product5 = new Product("Gafas Ciclista", "Proteccion para el sol", 60.000, "https://outletoptico.com/cdn/shop/products/ENCODEROO9471-0536OUTLETOPTICO_1167x700.png?v=1644852967");
        Product product6 = new Product("Montura Dama", "Modelo achatado", 280.000, "https://www.optica-torres.es/images/easyblog_articles/31/b2ap3_large_gafas-chanel-montura-multiopticas.png");
        Product product7 = new Product("Montura minimalista", "Ligeras", 160.000, "https://assets2.oliverpeoples.com/cdn-record-files-pi/c4e28542-fd40-4083-aff5-b0a501017c4d/18d62125-db5b-4cf2-8589-b0a501017f73/0OV5186__1756__P21__shad__qt.png?impolicy=OV_parameters_transp&wid=400");
        Product product8 = new Product("Gafas rojas", "Unicas", 122.000, "https://grandvision-media.imgix.net/m/bf34dd6626b73658/original_png-0RY9078V__3950__P21__shad__qt.png");
        listProducts.add(product1);
        listProducts.add(product2);
        listProducts.add(product3);
        listProducts.add(product4);
        listProducts.add(product5);
        listProducts.add(product6);
        listProducts.add(product7);
        listProducts.add(product8);
        listProducts.add(product4);
        listProducts.add(product1);
        listProducts.add(product2);
        listProducts.add(product3);
        listProducts.add(product4);
        listProducts.add(product5);
        listProducts.add(product6);
        listProducts.add(product7);
        listProducts.add(product8);
        listProducts.add(product1);
        listProducts.add(product2);
        listProducts.add(product3);
        listProducts.add(product4);


    }
}


