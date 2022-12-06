### Request
>Mr.Minh muốn tạo một trang web cho phép các khách hàng của
>anh ấy đặt phòng tại khách sạn của anh ấy. theo các yc dưới đây.

**Từ những yêu cầu về giao diện dưới đây hãy:**
1. thiết kế DB.
2. viết login cơ bản sử dụng jwt.
3. Hãy hình dung xem mình phải tạo các API nào để phục vụ các nghiệp vụ dưới.
4. các giao diện đều phải có CRUD và phân trang bằng Pageable. (VD: quản lý User, Room,...)

**NOTE:** chỉ viết API

____________________________________________________________________________________________________________________________________________________________________________________________________________
###I.Giao diện admin

>- giao diện quản lý users.
>- quản lý phòng (VD: phòng bt, phòng vip, phòng luxury) giá tiền phòng có thể thay đổi theo thời gian và mùa,
>  tầng view đẹp hay xấu, càng tầng cao giá sẽ cao hơn.
>- giao diện quản lý các dịch vụ đi kèm theo từng phòng.
>- xuất báo cáo số lượng khách đặt phòng trong tháng, và doanh thu của tháng đó bằng excel.
____________________________________________________________________________________________________________________________________________________________________________________________________________
###II.Giao diện web

>- đăng kí user.
>- chức năng kiểm tra còn phòng trống theo thời gian, sắp xếp phòng theo type và giá phòng
>  (có time line để theo dõi xem phòng nào đã được đặt hoặc sử dụng hay chưa, hay vẫn available)
>- chức năng đặt phòng :
>    +khach hanh chi dc check in va check out vao buoi trua.
>    + 1 khách hàng đặt tối đa 5 room,
>      mỗi phòng tối đa co 2 nguoi lon va 3 tre em
>      VD: co 7 người lớn va 8 trẻ em -> chỉ có thể thuê 4 phòng
>      _ phòng co 3 trang thai:
>      + đã dc đặt
>      + chưa đặt
>      + giữ chỗ
>    + mỗi loại phòng lại có một dịch vụ đi khèm khách nhau và có giá tiền khác nhau, có thể DK theo combo
>-chức năng thanh toán :
>
>    + hiển thị các phòng đã đặt và giá từng phòng + thêm các dịch vụ đk đi kèm.
>    + có thể có apply voucher theo đơn đặt phòng
>
>- chức năng gửi mail cho khách hàng khi hoàn tất thanh toán
>  (có đầy đủ thông tin đặt phòng và thông tin thanh toán) : 
	
