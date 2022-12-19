package vn.com.vatekasia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.vatekasia.dto.BillDTO;
import vn.com.vatekasia.dto.BookRoomDTO;
import vn.com.vatekasia.dto.ResponseDTO;
import vn.com.vatekasia.service.BillService;

@RestController
@RequestMapping("/api/book-room")
public class BookRoomControllerAPI {
  @Autowired
  BillService billService;
    @PostMapping("/create")
    private ResponseDTO<BillDTO>create(@RequestBody BookRoomDTO bookRoomDTO) {
            BillDTO billDTO = billService.createBookRoom(bookRoomDTO);
      return ResponseDTO.<BillDTO>builder().data(billDTO).message("thanh cong").build();
    }
}
