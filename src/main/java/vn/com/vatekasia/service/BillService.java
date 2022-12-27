package vn.com.vatekasia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.vatekasia.dto.BillDTO;
import vn.com.vatekasia.dto.BookRoomDTO;
import vn.com.vatekasia.entity.Bill;
import vn.com.vatekasia.entity.Room;
import vn.com.vatekasia.repository.BillRepository;
import vn.com.vatekasia.repository.CouponRepository;
import vn.com.vatekasia.repository.RoomRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    BillRepository billRepository;
    @Autowired
    CouponRepository couponRepo;

    public BillDTO createBookRoom(BookRoomDTO bookRoomDTO) {
        List<Room> rooms = bookRoomDTO.getRoomId().stream()
                .map(aLong -> roomRepository.findById(aLong).get())
                .collect(Collectors.toList());
        for (Room room : rooms) {

        }
        Bill bill = new Bill();
        bill.setName("name");
        bill.setPrice(0);
        bill.setTotalPayment(0l);
        bill.setBuyDate(new Date());
        bill.setTotalPay(0l);
        bill.setUser(bookRoomDTO.getUser());
        Bill resBill = billRepository.save(bill);

        for (Room room : rooms) {
            room.setBill(resBill);
            roomRepository.save(room);
        }
        BillDTO billDTO = new BillDTO();
        billDTO.setPrice(resBill.getPrice());
        billDTO.setName(resBill.getName());
        billDTO.setTotalPay(resBill.getTotalPay());
        billDTO.setListRoom(rooms);
        billDTO.setBuyDate(resBill.getBuyDate());
        billDTO.setId(resBill.getId());

        return billDTO;
    }


}
