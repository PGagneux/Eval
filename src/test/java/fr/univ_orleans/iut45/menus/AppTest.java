package fr.univ_orleans.iut45.menus;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class AppTest
{
    @Test
    public void testPrixPlats()
    {
        Plat carottes_rapees = new Plat("Carottes Rapées", false, new ArrayList<String>(), 0.5);
        ArrayList<String> allergenes_pb = new ArrayList<String>();
        allergenes_pb.add("gluten");
        allergenes_pb.add("fruits à coque");
        Plat paris_brest = new Plat ("Paris-Brest", false, allergenes_pb, 2.5);
        assertTrue(carottes_rapees.prixDeRevient() < paris_brest.prixDeRevient());
    }

    @Test
    public void testListeEntrees()
    {
        Plat carottes_rapees = new Plat("Carottes Rapées", false, new ArrayList<String>(), 0.5);
        ArrayList<Plat> les_entrees = new ArrayList<Plat>();
        les_entrees.add(carottes_rapees);
        Menu ce_midi = new Menu(les_entrees, new ArrayList<Plat>(), new ArrayList<Plat>());
        assertEquals(1, ce_midi.getEntrees().size());
    }

    @Test
    public void testMenuComplet()
    {
        Plat carottes_rapees = new Plat("Carottes Rapées", false, new ArrayList<String>(), 0.5);
        ArrayList<Plat> les_entrees = new ArrayList<Plat>();
        les_entrees.add(carottes_rapees);
        Menu ce_midi = new Menu(les_entrees, new ArrayList<Plat>(), new ArrayList<Plat>());
        assertEquals(false, ce_midi.estComplet());

        ArrayList<String> allergenes_pb = new ArrayList<String>();
        allergenes_pb.add("gluten");
        allergenes_pb.add("fruits à coque");
        Plat paris_brest = new Plat ("Paris-Brest", false, allergenes_pb, 2.5);
        ArrayList<Plat> les_desserts = new ArrayList<Plat>();
        les_desserts.add(paris_brest);

        ArrayList<String> allergenes_lasagnes = new ArrayList<String>();
        ArrayList<String> allergenes_tortilla = new ArrayList<String>();
        allergenes_lasagnes.add("gluten");
        allergenes_tortilla.add("oeufs");
        Plat lasagnes = new Plat("Lasagnes", true, allergenes_lasagnes, 2.8);
        Plat tortilla = new Plat("Tortilla", false, allergenes_tortilla, 1.8);
        ArrayList<Plat> les_plats_principaux = new ArrayList<Plat>();
        les_plats_principaux.add(lasagnes);
        les_plats_principaux.add(tortilla);
        Menu ce_soir = new Menu(les_entrees, les_plats_principaux, les_desserts);
        assertTrue(ce_soir.estComplet());
    }

}
