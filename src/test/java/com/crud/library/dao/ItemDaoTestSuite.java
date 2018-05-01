package com.crud.library.dao;

import com.crud.library.domain.Item;
import com.crud.library.domain.ItemStatus;
import com.crud.library.domain.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ItemDaoTestSuite {
    @Autowired
    ItemDao itemDao;
    @Autowired
    TitleDao titleDao;

    @Test
    public void testCreateItem() {
        //Given
        Title title = new Title("W pustyni i w puszczy", "Sienkiewicz Henryk", 2000);
        titleDao.save(title);
        Item item = new Item(title, ItemStatus.BORROWED);
        title.getItemList().add(item);

        //When
        itemDao.save(item);
        int id = item.getId();
        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
//        titleDao.delete(title);
    }

}