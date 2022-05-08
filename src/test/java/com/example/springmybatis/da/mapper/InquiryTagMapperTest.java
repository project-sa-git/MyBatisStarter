package com.example.springmybatis.da.mapper;

import com.example.springmybatis.da.entity.InquiryTag;
import com.example.springmybatis.da.query.InquiryTagSelectQuery;
import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class InquiryTagMapperTest {

    @Autowired
    private InquiryTagMapper inquiryTagMapper;

    @Test
    void find() {
        // ハンズオン 1-4 コメントアウトを解除してテストを実行
        var inquiryTag = inquiryTagMapper.find(1);

        assertNotNull(inquiryTag);

        assertEquals("問合せ", inquiryTag.getDescription());

    }

    @Test
    void select() {
        // ハンズオン 2-3 コメントアウトを解除してテストを実行
        var query = new InquiryTagSelectQuery();

        query.setDescription("問合せ");

        query.addOrderCondition(InquiryTagSelectQuery.OrderByField.INQUIRY_ID, InquiryTagSelectQuery.SortOrder.DESC);
        query.addOrderCondition(InquiryTagSelectQuery.OrderByField.ID, InquiryTagSelectQuery.SortOrder.ASC);

        var list = inquiryTagMapper.select(query, new RowBounds(0, 100));

        assertEquals(2, list.size());

        var inquiryTag = list.get(0);

        assertEquals(7, inquiryTag.getId());
    }


	@Test
    void insertUpdateDelete() {
        // TODO ハンズオン 3-3 コメントアウトを解除してテストを実行
        var inquiryTag = new InquiryTag();
        inquiryTag.setInquiryId(1);
        inquiryTag.setDescription("保存");
        inquiryTag.setCreated(LocalDateTime.now());

        inquiryTagMapper.insert(inquiryTag);

        // 今入れた値がpkeyで8になっているか確認する
        assertEquals(8, inquiryTag.getId());

        // 保存を保管に変更
        inquiryTag.setDescription("保管");

        inquiryTagMapper.update(inquiryTag);

        var updatedInquiryTag = inquiryTagMapper.find(8);

        assertNotNull(updatedInquiryTag);

        assertEquals(updatedInquiryTag.getDescription(), inquiryTag.getDescription());

        inquiryTagMapper.delete(8);

        var deletedInquiryTag = inquiryTagMapper.find(8);

        assertNull(deletedInquiryTag);

    }

	@Test
    void findView() {
        // TODO ハンズオン 4-4 コメントアウトを解除してテストを実行
//        var inquiryTagView = inquiryTagMapper.findView(1);
//
//        assertNotNull(inquiryTagView);
//
//        var inquiry = inquiryTagView.getInquiry();
//
//        assertNotNull(inquiry);
//
//        assertEquals("Contents1", inquiry.getContents());
    }

	@Test
    void findView2() {
        // TODO ハンズオン 4-8 コメントアウトを解除してテストを実行
//        var inquiryTagView = inquiryTagMapper.findView2(1);
//
//        assertNotNull(inquiryTagView);
//
//        var inquiry = inquiryTagView.getInquiry();
//
//        assertNotNull(inquiry);
//
//        assertEquals("Contents1", inquiry.getContents());
    }
}
