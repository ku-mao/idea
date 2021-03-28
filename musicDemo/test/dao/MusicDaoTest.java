package dao;

import org.junit.Test;

public class MusicDaoTest {

    @Test
    public void findAll() {
        MusicDao musicDao = new MusicDao();
        System.out.println(musicDao.findAll());
    }

    @Test
    public void findMusicById() {
        MusicDao musicDao = new MusicDao();
        System.out.println(musicDao.findMusicById(28));
        System.out.println(musicDao.findMusicById(40));
    }

    @Test
    public void ifMusic() {
        MusicDao musicDao = new MusicDao();
        System.out.println(musicDao.ifMusic("永"));
        System.out.println(musicDao.ifMusic("夏"));
    }

    @Test
    public void add() {
        MusicDao musicDao = new MusicDao();
        musicDao.add("暖暖", "梁静茹", "2020-9-5","music/暖暖",2);
    }

    @Test
    public void deleteById() {
        MusicDao musicDao = new MusicDao();
        musicDao.deleteById(32);
        musicDao.deleteById(1);
    }

    @Test
    public void findLoveMusic() {
        MusicDao musicDao = new MusicDao();
        System.out.println(musicDao.findLoveMusic(7));
        System.out.println(musicDao.findLoveMusic(2));
    }

    @Test
    public void findLoveMusicById() {
        MusicDao musicDao = new MusicDao();
        System.out.println(musicDao.findLoveMusicById(2, 2));
    }

    @Test
    public void addLoveMusic() {
        MusicDao musicDao = new MusicDao();
        musicDao.addLoveMusic(2, 29);
    }

    @Test
    public void deleteLoveMusic() {
        MusicDao musicDao = new MusicDao();
        musicDao.deleteLoveMusic(8, 29);
    }

    @Test
    public void findAllLoveMusic() {
        MusicDao musicDao = new MusicDao();
        System.out.println(musicDao.findAllLoveMusic(2));
    }

    @Test
    public void findIfLoveMusic() {
        MusicDao musicDao = new MusicDao();
        System.out.println(musicDao.findIfLoveMusic("永", 1));
    }
}