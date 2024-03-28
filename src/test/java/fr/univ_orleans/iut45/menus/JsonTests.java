package fr.univ_orleans.iut45.menus;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class JsonTests
{

    @Test
    public void lectureJsonPlat()
        throws FileNotFoundException
    {
        FileReader fichier_json = new FileReader("chili.json");
        Plat chili_sin_carne = Plat.fromJson(fichier_json);
        assertTrue(chili_sin_carne.prixDeRevient() < 1.6);
        assertTrue(chili_sin_carne.prixDeRevient() > 1.4);
    }

    @Test
    public void lectureJsonMenu()
        throws FileNotFoundException
    {
        FileReader fichier_json = new FileReader("ce_midi.json");
        Menu ce_midi = Menu.fromJson(fichier_json);
        assertEquals(1, ce_midi.getEntrees().size());
    }

}
