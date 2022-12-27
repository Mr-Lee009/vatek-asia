package vn.com.vatekasia.util;

import lombok.Data;
import vn.com.vatekasia.entity.Combo;

import java.util.List;

@Data
public class ListCombo {
    private List<Combo> listCombo;
    private int size;
    private int totalPage;
    private int page;
}
