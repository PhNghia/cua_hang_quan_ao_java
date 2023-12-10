-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 10, 2023 at 04:36 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cua_hang_quan_ao_db`
--
CREATE DATABASE IF NOT EXISTS `cua_hang_quan_ao_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `cua_hang_quan_ao_db`;

-- --------------------------------------------------------

--
-- Table structure for table `chi_tiet_chuc_nang`
--

CREATE TABLE `chi_tiet_chuc_nang` (
  `hanh_dong` varchar(100) NOT NULL,
  `sap_xep_stt` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chi_tiet_chuc_nang`
--

INSERT INTO `chi_tiet_chuc_nang` (`hanh_dong`, `sap_xep_stt`) VALUES
('Áp dụng khuyến mãi', 5),
('Quy chế tích điểm', 4),
('Sửa khách hàng', 3),
('Sửa khuyến mãi', 3),
('Sửa nhà cung cấp', 3),
('Sửa nhân viên', 3),
('Sửa nhóm quyền', 3),
('Sửa sản phẩm', 3),
('Sửa tài khoản', 3),
('Thêm hóa đơn bán', 2),
('Thêm hóa đơn mua', 2),
('Thêm khách hàng', 2),
('Thêm khuyến mãi', 2),
('Thêm nhà cung cấp', 2),
('Thêm nhân viên', 2),
('Thêm nhóm quyền', 2),
('Thêm sản phẩm', 2),
('Thêm tài khoản', 2),
('Thu hồi hóa đơn bán', 3),
('Thu hồi hóa đơn mua', 3),
('Xem hóa đơn bán', 1),
('Xem hóa đơn mua', 1),
('Xem khách hàng', 1),
('Xem khuyến mãi', 1),
('Xem nhà cung cấp', 1),
('Xem nhân viên', 1),
('Xem nhóm quyền', 1),
('Xem sản phẩm', 1),
('Xem tài khoản', 1),
('Xem thống kê', 1),
('Xóa khuyến mãi', 4),
('Xóa nhân viên', 4),
('Xóa nhóm quyền', 4),
('Xóa sản phẩm', 4),
('Xóa tài khoản', 4);

-- --------------------------------------------------------

--
-- Table structure for table `chi_tiet_hoa_don_ban`
--

CREATE TABLE `chi_tiet_hoa_don_ban` (
  `ma_hoa_don` varchar(20) NOT NULL,
  `ma_san_pham` varchar(10) NOT NULL,
  `ten_san_pham` varchar(100) NOT NULL,
  `gia_ban` int(11) NOT NULL,
  `giam_gia` float NOT NULL,
  `so_luong` int(11) NOT NULL,
  `tong_tien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chi_tiet_hoa_don_ban`
--

INSERT INTO `chi_tiet_hoa_don_ban` (`ma_hoa_don`, `ma_san_pham`, `ten_san_pham`, `gia_ban`, `giam_gia`, `so_luong`, `tong_tien`) VALUES
('HDB20231210N1', 'A4', 'Áo Hoodie Gấu', 100000, 0, 2, 200000),
('HDB20231210N1', 'Q1', 'Quần Gấu Nâu', 10000, 0, 3, 30000),
('HDB20231210N2', 'A5', 'Áo Sweater CEC', 100000, 0, 1, 100000),
('HDB20231210N2', 'A6', 'Áo Sơ Mi Logo Gấu', 80000, 0, 1, 80000),
('HDB20231210N2', 'A7', 'Áo Thun CEC', 80000, 0, 1, 80000),
('HDB20231210N3', 'Q2', 'Quần Jeans Ống Rộng', 10000, 0, 1, 10000),
('HDB20231210N3', 'Q3', 'Quần Thun Sọc Trắng', 10000, 0, 1, 10000);

-- --------------------------------------------------------

--
-- Table structure for table `chi_tiet_hoa_don_mua`
--

CREATE TABLE `chi_tiet_hoa_don_mua` (
  `ma_hoa_don` varchar(20) NOT NULL,
  `ma_san_pham` varchar(10) NOT NULL,
  `ma_ncc` int(11) NOT NULL,
  `gia_nhap` int(11) NOT NULL,
  `so_luong` int(11) NOT NULL,
  `tong_tien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chi_tiet_hoa_don_mua`
--

INSERT INTO `chi_tiet_hoa_don_mua` (`ma_hoa_don`, `ma_san_pham`, `ma_ncc`, `gia_nhap`, `so_luong`, `tong_tien`) VALUES
('HDM20231210N1', 'A4', 14, 20000, 22, 440000),
('HDM20231210N1', 'A5', 14, 20000, 1, 20000),
('HDM20231210N1', 'A6', 14, 20000, 1, 20000),
('HDM20231210N1', 'A7', 14, 20000, 1, 20000),
('HDM20231210N1', 'Q1', 14, 20000, 3, 60000),
('HDM20231210N1', 'Q2', 14, 20000, 1, 20000),
('HDM20231210N1', 'Q3', 14, 20000, 1, 20000),
('HDM20231210N2', 'Q3', 1, 15000, 20, 300000),
('HDM20231210N3', 'A7', 18, 20000, 50, 1000000);

-- --------------------------------------------------------

--
-- Table structure for table `chi_tiet_khuyen_mai`
--

CREATE TABLE `chi_tiet_khuyen_mai` (
  `id_dot_khuyen_mai` int(11) NOT NULL,
  `ma_san_pham` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chi_tiet_khuyen_mai`
--

INSERT INTO `chi_tiet_khuyen_mai` (`id_dot_khuyen_mai`, `ma_san_pham`) VALUES
(1, 'A2'),
(1, 'A3'),
(1, 'A4'),
(1, 'A5'),
(1, 'A6'),
(1, 'A7'),
(1, 'Q1'),
(1, 'Q2'),
(1, 'Q3'),
(2, 'Q1'),
(2, 'Q2'),
(3, 'A2'),
(3, 'A7'),
(3, 'Q3'),
(5, 'A4'),
(5, 'A5'),
(5, 'A6'),
(5, 'A7'),
(5, 'Q1'),
(5, 'Q2'),
(6, 'A4'),
(6, 'A5'),
(6, 'A6'),
(6, 'A7'),
(6, 'Q1'),
(6, 'Q2'),
(6, 'Q3'),
(8, 'A4'),
(8, 'A5'),
(8, 'A6'),
(8, 'A7'),
(8, 'Q1'),
(8, 'Q2'),
(8, 'Q3'),
(10, 'A4'),
(10, 'A5'),
(10, 'A6'),
(10, 'A7'),
(13, 'Q1'),
(13, 'Q2'),
(13, 'Q3'),
(14, 'A4'),
(14, 'A5'),
(14, 'A6'),
(14, 'A7');

-- --------------------------------------------------------

--
-- Table structure for table `chi_tiet_nhom_quyen`
--

CREATE TABLE `chi_tiet_nhom_quyen` (
  `ma_nhom_quyen` varchar(10) NOT NULL,
  `ma_chuc_nang` int(11) NOT NULL,
  `hanh_dong` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chi_tiet_nhom_quyen`
--

INSERT INTO `chi_tiet_nhom_quyen` (`ma_nhom_quyen`, `ma_chuc_nang`, `hanh_dong`) VALUES
('AD', 1, 'Sửa tài khoản'),
('AD', 1, 'Thêm tài khoản'),
('AD', 1, 'Xem tài khoản'),
('AD', 1, 'Xóa tài khoản'),
('AD', 2, 'Sửa nhóm quyền'),
('AD', 2, 'Thêm nhóm quyền'),
('AD', 2, 'Xem nhóm quyền'),
('AD', 2, 'Xóa nhóm quyền'),
('AD', 3, 'Xem nhân viên'),
('NV', 4, 'Sửa khách hàng'),
('NV', 4, 'Thêm khách hàng'),
('NV', 4, 'Xem khách hàng'),
('NV', 5, 'Xem sản phẩm'),
('NV', 9, 'Thêm hóa đơn bán'),
('NV', 9, 'Thu hồi hóa đơn bán'),
('NV', 9, 'Xem hóa đơn bán'),
('NV', 11, 'Xem khuyến mãi'),
('NV', 13, 'Xem thống kê'),
('QL', 1, 'Sửa tài khoản'),
('QL', 1, 'Thêm tài khoản'),
('QL', 1, 'Xem tài khoản'),
('QL', 1, 'Xóa tài khoản'),
('QL', 2, 'Sửa nhóm quyền'),
('QL', 2, 'Thêm nhóm quyền'),
('QL', 2, 'Xem nhóm quyền'),
('QL', 2, 'Xóa nhóm quyền'),
('QL', 3, 'Sửa nhân viên'),
('QL', 3, 'Thêm nhân viên'),
('QL', 3, 'Xem nhân viên'),
('QL', 3, 'Xóa nhân viên'),
('QL', 4, 'Quy chế tích điểm'),
('QL', 4, 'Sửa khách hàng'),
('QL', 4, 'Thêm khách hàng'),
('QL', 4, 'Xem khách hàng'),
('QL', 5, 'Sửa sản phẩm'),
('QL', 5, 'Thêm sản phẩm'),
('QL', 5, 'Xem sản phẩm'),
('QL', 5, 'Xóa sản phẩm'),
('QL', 6, 'Sửa nhà cung cấp'),
('QL', 6, 'Thêm nhà cung cấp'),
('QL', 6, 'Xem nhà cung cấp'),
('QL', 9, 'Thêm hóa đơn bán'),
('QL', 9, 'Thu hồi hóa đơn bán'),
('QL', 9, 'Xem hóa đơn bán'),
('QL', 10, 'Thêm hóa đơn mua'),
('QL', 10, 'Thu hồi hóa đơn mua'),
('QL', 10, 'Xem hóa đơn mua'),
('QL', 11, 'Áp dụng khuyến mãi'),
('QL', 11, 'Sửa khuyến mãi'),
('QL', 11, 'Thêm khuyến mãi'),
('QL', 11, 'Xem khuyến mãi'),
('QL', 11, 'Xóa khuyến mãi'),
('QL', 13, 'Xem thống kê');

-- --------------------------------------------------------

--
-- Table structure for table `chuc_nang`
--

CREATE TABLE `chuc_nang` (
  `ma_chuc_nang` int(11) NOT NULL,
  `ten_chuc_nang` varchar(100) NOT NULL,
  `icon` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chuc_nang`
--

INSERT INTO `chuc_nang` (`ma_chuc_nang`, `ten_chuc_nang`, `icon`) VALUES
(1, 'Tài khoản', '/image/icons8-account-60.png'),
(2, 'Nhóm quyền', '/image/icons8-permission-60.png'),
(3, 'Nhân viên', '/image/icons8-employee-60.png'),
(4, 'Khách hàng', '/image/icons8-customer-60.png'),
(5, 'Sản phẩm', '/image/icons8-product-60.png'),
(6, 'Nhà cung cấp', '/image/icons8-provider-60.png'),
(9, 'Hóa đơn bán', '/image/icons8-order2-60.png'),
(10, 'Hóa đơn mua', '/image/icons8-order-60.png'),
(11, 'Khuyến mãi', '/image/icons8-sale-60.png'),
(13, 'Thống kê', '/image/icons8-analytics-60.png');

-- --------------------------------------------------------

--
-- Table structure for table `dot_khuyen_mai`
--

CREATE TABLE `dot_khuyen_mai` (
  `id_dot_khuyen_mai` int(11) NOT NULL,
  `ma_khuyen_mai` varchar(20) NOT NULL,
  `ngay_bat_dau` datetime NOT NULL,
  `ngay_ket_thuc` datetime NOT NULL,
  `gia_tri` float NOT NULL,
  `trang_thai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dot_khuyen_mai`
--

INSERT INTO `dot_khuyen_mai` (`id_dot_khuyen_mai`, `ma_khuyen_mai`, `ngay_bat_dau`, `ngay_ket_thuc`, `gia_tri`, `trang_thai`) VALUES
(1, 'BDVANNGHIA', '2023-10-20 00:00:00', '2023-10-20 00:00:00', 100, 0),
(2, 'BDVANNGHIA', '2024-10-20 00:00:00', '2024-10-21 23:59:00', 99, 0),
(3, 'BDVANNGHIA', '2024-09-07 00:00:00', '2024-09-07 23:59:00', 2, 1),
(5, 'HPTEACHERDAY', '2023-11-20 00:00:00', '2023-11-30 00:00:00', 30, 0),
(6, 'HPTEACHERDAY', '2024-11-20 00:00:00', '2024-11-30 23:59:00', 30, 1),
(7, 'HPTEACHERDAY', '2022-11-20 00:00:00', '2022-11-30 00:00:00', 30, 0),
(8, 'BDVANNGHIA', '2023-11-30 00:00:00', '2023-11-30 23:59:00', 2, 0),
(9, 'BDVANNGHIA', '2023-11-26 00:00:00', '2023-11-26 23:59:00', 2, 0),
(10, 'TODAY', '2023-12-10 00:00:00', '2023-12-10 23:59:00', 50, 2),
(13, 'TODAY2', '2023-12-10 00:00:00', '2023-12-10 23:59:00', 1, 2),
(14, 'TODAY', '2023-12-12 00:00:00', '2023-12-13 23:59:00', 50, 1),
(15, 'HPTEACHERDAY', '2023-12-12 00:00:00', '2023-12-12 23:59:00', 12, 1);

-- --------------------------------------------------------

--
-- Table structure for table `hoa_don_ban`
--

CREATE TABLE `hoa_don_ban` (
  `ma_hoa_don` varchar(20) NOT NULL,
  `ma_khach_hang` int(11) NOT NULL,
  `ma_nhan_vien` int(11) NOT NULL,
  `ngay_tao` datetime NOT NULL,
  `tong_tien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hoa_don_ban`
--

INSERT INTO `hoa_don_ban` (`ma_hoa_don`, `ma_khach_hang`, `ma_nhan_vien`, `ngay_tao`, `tong_tien`) VALUES
('HDB20231210N1', 1, 1, '2023-12-10 22:31:58', 230000),
('HDB20231210N2', 5, 1, '2023-12-10 22:32:24', 260000),
('HDB20231210N3', 3, 1, '2023-12-10 22:33:13', 20000);

-- --------------------------------------------------------

--
-- Table structure for table `hoa_don_mua`
--

CREATE TABLE `hoa_don_mua` (
  `ma_hoa_don` varchar(20) NOT NULL,
  `ma_nhan_vien` int(11) NOT NULL,
  `ngay_tao` datetime NOT NULL,
  `tong_tien` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hoa_don_mua`
--

INSERT INTO `hoa_don_mua` (`ma_hoa_don`, `ma_nhan_vien`, `ngay_tao`, `tong_tien`) VALUES
('HDM20231210N1', 1, '2023-12-10 22:33:53', 600000),
('HDM20231210N2', 1, '2023-12-10 22:34:26', 300000),
('HDM20231210N3', 1, '2023-12-10 22:35:12', 1000000);

-- --------------------------------------------------------

--
-- Table structure for table `khach_hang`
--

CREATE TABLE `khach_hang` (
  `ma_khach_hang` int(11) NOT NULL,
  `ten_khach_hang` varchar(100) NOT NULL,
  `sdt` varchar(12) NOT NULL,
  `tien_tich_luy` int(11) NOT NULL,
  `diem_tich_luy` int(11) NOT NULL,
  `bang_tien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khach_hang`
--

INSERT INTO `khach_hang` (`ma_khach_hang`, `ten_khach_hang`, `sdt`, `tien_tich_luy`, `diem_tich_luy`, `bang_tien`) VALUES
(1, 'Khách hàng 1', '0913411565', 230000, 23, 2300),
(2, 'Khách hàng 2', '0352342233', 0, 0, 0),
(3, 'Khách hàng 3', '0911900565', 20000, 2, 200),
(4, 'Khách hàng 4', '0358112963', 0, 0, 0),
(5, '-------', '', 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `khuyen_mai`
--

CREATE TABLE `khuyen_mai` (
  `ma_khuyen_mai` varchar(20) NOT NULL,
  `ten_khuyen_mai` varchar(200) NOT NULL,
  `trang_thai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khuyen_mai`
--

INSERT INTO `khuyen_mai` (`ma_khuyen_mai`, `ten_khuyen_mai`, `trang_thai`) VALUES
('BDVANNGHIA', 'Mừng sinh nhật nhân viên quèn Nghĩa NN - Giảm mạnh 2% các loại áo quần secondhand.', 0),
('HPTEACHERDAY', 'Mừng ngày nhà giáo Việt Nam 20-11 giảm 20% một số trang phục dự tiệc.', 1),
('TODAY', 'Khuyến mãi cho hôm nay', 0),
('TODAY2', 'Khuyến mãi cho hôm nay 2', 0);

-- --------------------------------------------------------

--
-- Table structure for table `nhan_vien`
--

CREATE TABLE `nhan_vien` (
  `ma_nhan_vien` int(11) NOT NULL,
  `ten_nhan_vien` varchar(100) NOT NULL,
  `gioi_tinh` int(11) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `sdt` varchar(12) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `dia_chi` varchar(100) DEFAULT NULL,
  `ma_nhom_quyen` varchar(10) NOT NULL,
  `trang_thai` int(11) NOT NULL,
  `hien_thi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhan_vien`
--

INSERT INTO `nhan_vien` (`ma_nhan_vien`, `ten_nhan_vien`, `gioi_tinh`, `ngay_sinh`, `sdt`, `email`, `dia_chi`, `ma_nhom_quyen`, `trang_thai`, `hien_thi`) VALUES
(1, 'Nguyễn Văn A', 1, '2023-10-11', '0914400565', 'nguyena@gmail.com', '44 Nguyễn Trãi, HCM', 'QL', 1, 1),
(2, 'Nguyễn Văn B', 0, '2023-10-11', '0914300566', 'nguyenb@gmail.com', '44 An Dương Vương, HCM', 'AD', 1, 1),
(3, 'Nguyễn Văn C', 1, '2023-10-11', '0914200565', 'nguyenc@gmail.com', '44 Trần Hưng Đạo, HCM', 'NV', 1, 1),
(8, 'Nguyễn Văn D', 0, '2023-10-11', '0914100565', 'nguyend@gmail.com', '44 Nguyễn Văn Cừ, HCM', 'AD', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `nha_cung_cap`
--

CREATE TABLE `nha_cung_cap` (
  `ma_ncc` int(11) NOT NULL,
  `ten_ncc` varchar(100) NOT NULL,
  `sdt` varchar(12) DEFAULT NULL,
  `dia_chi` varchar(100) DEFAULT NULL,
  `trang_thai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nha_cung_cap`
--

INSERT INTO `nha_cung_cap` (`ma_ncc`, `ten_ncc`, `sdt`, `dia_chi`, `trang_thai`) VALUES
(1, 'Nhà cung cấp ABC', '0913400565', '401 Âu Cơ, Phường 14, Quận 11', 1),
(2, 'Nhà cung cấp XYZ', '0913400562', '25 An Dương Vương, Quận 5', 0),
(3, 'Nhà cung cấp MNP', '0913400265', '101 Nguyễn Trãi, Quận 5', 1),
(14, 'Nhà cung cấp 123', '0914400565', 'HCM', 1),
(15, 'Nhà cung cấp 456', '0914400564', 'HCM', 1),
(16, 'Nhà cung cấp 789', '0914400555', 'Bình Thuận', 1),
(17, 'Nhà cung cấp ABC1', '0914400543', 'HCM', 1),
(18, 'Nhà cung cấp MNP1', NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhom_quyen`
--

CREATE TABLE `nhom_quyen` (
  `ma_nhom_quyen` varchar(10) NOT NULL,
  `ten_nhom_quyen` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhom_quyen`
--

INSERT INTO `nhom_quyen` (`ma_nhom_quyen`, `ten_nhom_quyen`) VALUES
('AD', 'Admin'),
('NV', 'Nhân viên'),
('QL', 'Quản lí');

-- --------------------------------------------------------

--
-- Table structure for table `quy_uoc_tich_diem`
--

CREATE TABLE `quy_uoc_tich_diem` (
  `menh_gia` int(11) NOT NULL,
  `bang_diem` int(11) NOT NULL,
  `bang_tien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `quy_uoc_tich_diem`
--

INSERT INTO `quy_uoc_tich_diem` (`menh_gia`, `bang_diem`, `bang_tien`) VALUES
(10000, 1, 100);

-- --------------------------------------------------------

--
-- Table structure for table `san_pham`
--

CREATE TABLE `san_pham` (
  `ma_san_pham` varchar(10) NOT NULL,
  `ten_san_pham` varchar(100) NOT NULL,
  `chat_lieu` varchar(100) DEFAULT NULL,
  `kich_co` varchar(100) DEFAULT NULL,
  `mau_sac` varchar(100) DEFAULT NULL,
  `gia_ban` int(11) DEFAULT NULL,
  `so_luong` int(11) DEFAULT NULL,
  `hinh_anh` varchar(200) DEFAULT NULL,
  `trang_thai` int(11) NOT NULL,
  `hien_thi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `san_pham`
--

INSERT INTO `san_pham` (`ma_san_pham`, `ten_san_pham`, `chat_lieu`, `kich_co`, `mau_sac`, `gia_ban`, `so_luong`, `hinh_anh`, `trang_thai`, `hien_thi`) VALUES
('A1', 'Áo thun mèo', 'Cotton', 'S', 'Vàng', 50000, 100, 'upload\\productImages\\ảnh_Áo_thun_mèo_1702221779846.png', 0, 1),
('A2', 'Áo Thun Gấu', 'Cotton', 'L', 'Nâu', 10000, 102, 'upload\\productImages\\ảnh_Áo_Thun_Gấu_1702221817866.jpg&ehk=j7gAaqeR9DXn0I5QgMNiDZKWBFn45GDTIL%2b7BRJf51M%3d&risl=&pid=ImgRaw&r=0', 1, 1),
('A3', 'Áo Khoác Logo Gấu nâu', 'Nỉ chân cua', 'S', 'Vàng', 150000, 100, 'upload\\productImages\\ảnh_Áo_Khoác_Logo_Gấu_nâu_1702221844208.png', 1, 1),
('A4', 'Áo Hoodie Gấu', 'Cotton', 'M', 'Nâu', 100000, 120, 'upload\\productImages\\ảnh_Áo_Hoodie_Gấu_1702221864118.jpg', 2, 1),
('A5', 'Áo Sweater CEC', 'Nỉ chân cua', 'S', 'Xám', 100000, 100, 'upload\\productImages\\ảnh_Áo_Sweater_CEC_1702221888008.jpg', 2, 1),
('A6', 'Áo Sơ Mi Logo Gấu', 'Kate', 'M', 'Vàng', 80000, 100, 'upload\\productImages\\ảnh_Áo_Sơ_Mi_Logo_Gấu_1702221912849.png', 2, 1),
('A7', 'Áo Thun CEC', 'Cotton', 'XL', 'Hồng', 80000, 150, 'upload\\productImages\\ảnh_Áo_Thun_CEC_1702221952340.png', 2, 1),
('Q1', 'Quần Gấu Nâu', 'Cotton', 'M', 'Nâu', 10000, 100, 'upload\\productImages\\ảnh_Quần_Gấu_Nâu_1702221974708.png', 2, 1),
('Q2', 'Quần Jeans Ống Rộng', 'Jeans', 'XL', 'Xanh', 10000, 100, 'upload\\productImages\\ảnh_Quần_Jeans_Ống_Rộng_1702221996447.png', 2, 1),
('Q3', 'Quần Thun Sọc Trắng', 'Cotton', 'L', 'Đen', 10000, 120, 'upload\\productImages\\ảnh_Quần_Thun_Sọc_Trắng_1702222030593.jpg&ehk=KzrXBFdDorbwoZh7hospEYb2oDx3P%2bbYgnQMti%2fAcPo%3d&risl=&pid=ImgRaw&r=0', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tai_khoan`
--

CREATE TABLE `tai_khoan` (
  `ten_tai_khoan` varchar(100) NOT NULL,
  `mat_khau` varchar(100) NOT NULL,
  `ma_nhan_vien` int(11) NOT NULL,
  `ngay_tao` datetime NOT NULL,
  `trang_thai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tai_khoan`
--

INSERT INTO `tai_khoan` (`ten_tai_khoan`, `mat_khau`, `ma_nhan_vien`, `ngay_tao`, `trang_thai`) VALUES
('nguyenvanb', 'nguyenvanb', 2, '2023-12-10 21:31:45', 1),
('nguyenvanc', 'nguyenvanc', 3, '2023-12-10 21:19:12', 1),
('quanli', 'quanli', 1, '2023-11-28 14:47:14', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chi_tiet_chuc_nang`
--
ALTER TABLE `chi_tiet_chuc_nang`
  ADD PRIMARY KEY (`hanh_dong`);

--
-- Indexes for table `chi_tiet_hoa_don_ban`
--
ALTER TABLE `chi_tiet_hoa_don_ban`
  ADD PRIMARY KEY (`ma_hoa_don`,`ma_san_pham`),
  ADD KEY `ma_hoa_don` (`ma_hoa_don`,`ma_san_pham`),
  ADD KEY `ma_san_pham` (`ma_san_pham`);

--
-- Indexes for table `chi_tiet_hoa_don_mua`
--
ALTER TABLE `chi_tiet_hoa_don_mua`
  ADD PRIMARY KEY (`ma_hoa_don`,`ma_san_pham`,`ma_ncc`),
  ADD KEY `ma_hoa_don` (`ma_hoa_don`,`ma_san_pham`,`ma_ncc`),
  ADD KEY `ma_ncc` (`ma_ncc`),
  ADD KEY `ma_san_pham` (`ma_san_pham`);

--
-- Indexes for table `chi_tiet_khuyen_mai`
--
ALTER TABLE `chi_tiet_khuyen_mai`
  ADD PRIMARY KEY (`id_dot_khuyen_mai`,`ma_san_pham`),
  ADD KEY `chi_tiet_khuyen_mai_ibfk_1` (`ma_san_pham`);

--
-- Indexes for table `chi_tiet_nhom_quyen`
--
ALTER TABLE `chi_tiet_nhom_quyen`
  ADD PRIMARY KEY (`ma_nhom_quyen`,`ma_chuc_nang`,`hanh_dong`),
  ADD KEY `ma_chuc_nang` (`ma_chuc_nang`),
  ADD KEY `ma_nhom_quyen` (`ma_nhom_quyen`),
  ADD KEY `chi_tiet_nhom_quyen_ibfk_3` (`hanh_dong`);

--
-- Indexes for table `chuc_nang`
--
ALTER TABLE `chuc_nang`
  ADD PRIMARY KEY (`ma_chuc_nang`);

--
-- Indexes for table `dot_khuyen_mai`
--
ALTER TABLE `dot_khuyen_mai`
  ADD PRIMARY KEY (`id_dot_khuyen_mai`),
  ADD KEY `dot_khuyen_mai_ibfk_1` (`ma_khuyen_mai`);

--
-- Indexes for table `hoa_don_ban`
--
ALTER TABLE `hoa_don_ban`
  ADD PRIMARY KEY (`ma_hoa_don`),
  ADD KEY `ma_khach_hang` (`ma_khach_hang`),
  ADD KEY `ma_nhan_vien` (`ma_nhan_vien`);

--
-- Indexes for table `hoa_don_mua`
--
ALTER TABLE `hoa_don_mua`
  ADD PRIMARY KEY (`ma_hoa_don`),
  ADD KEY `ma_nhan_vien` (`ma_nhan_vien`);

--
-- Indexes for table `khach_hang`
--
ALTER TABLE `khach_hang`
  ADD PRIMARY KEY (`ma_khach_hang`);

--
-- Indexes for table `khuyen_mai`
--
ALTER TABLE `khuyen_mai`
  ADD PRIMARY KEY (`ma_khuyen_mai`);

--
-- Indexes for table `nhan_vien`
--
ALTER TABLE `nhan_vien`
  ADD PRIMARY KEY (`ma_nhan_vien`),
  ADD KEY `ma_nhom_quyen` (`ma_nhom_quyen`);

--
-- Indexes for table `nha_cung_cap`
--
ALTER TABLE `nha_cung_cap`
  ADD PRIMARY KEY (`ma_ncc`);

--
-- Indexes for table `nhom_quyen`
--
ALTER TABLE `nhom_quyen`
  ADD PRIMARY KEY (`ma_nhom_quyen`);

--
-- Indexes for table `san_pham`
--
ALTER TABLE `san_pham`
  ADD PRIMARY KEY (`ma_san_pham`);

--
-- Indexes for table `tai_khoan`
--
ALTER TABLE `tai_khoan`
  ADD PRIMARY KEY (`ten_tai_khoan`),
  ADD KEY `ma_nhan_vien` (`ma_nhan_vien`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chuc_nang`
--
ALTER TABLE `chuc_nang`
  MODIFY `ma_chuc_nang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `dot_khuyen_mai`
--
ALTER TABLE `dot_khuyen_mai`
  MODIFY `id_dot_khuyen_mai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `khach_hang`
--
ALTER TABLE `khach_hang`
  MODIFY `ma_khach_hang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `nhan_vien`
--
ALTER TABLE `nhan_vien`
  MODIFY `ma_nhan_vien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `nha_cung_cap`
--
ALTER TABLE `nha_cung_cap`
  MODIFY `ma_ncc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chi_tiet_hoa_don_ban`
--
ALTER TABLE `chi_tiet_hoa_don_ban`
  ADD CONSTRAINT `chi_tiet_hoa_don_ban_ibfk_1` FOREIGN KEY (`ma_san_pham`) REFERENCES `san_pham` (`ma_san_pham`),
  ADD CONSTRAINT `chi_tiet_hoa_don_ban_ibfk_2` FOREIGN KEY (`ma_hoa_don`) REFERENCES `hoa_don_ban` (`ma_hoa_don`);

--
-- Constraints for table `chi_tiet_hoa_don_mua`
--
ALTER TABLE `chi_tiet_hoa_don_mua`
  ADD CONSTRAINT `chi_tiet_hoa_don_mua_ibfk_1` FOREIGN KEY (`ma_ncc`) REFERENCES `nha_cung_cap` (`ma_ncc`),
  ADD CONSTRAINT `chi_tiet_hoa_don_mua_ibfk_2` FOREIGN KEY (`ma_san_pham`) REFERENCES `san_pham` (`ma_san_pham`),
  ADD CONSTRAINT `chi_tiet_hoa_don_mua_ibfk_3` FOREIGN KEY (`ma_hoa_don`) REFERENCES `hoa_don_mua` (`ma_hoa_don`);

--
-- Constraints for table `chi_tiet_khuyen_mai`
--
ALTER TABLE `chi_tiet_khuyen_mai`
  ADD CONSTRAINT `chi_tiet_khuyen_mai_ibfk_1` FOREIGN KEY (`ma_san_pham`) REFERENCES `san_pham` (`ma_san_pham`),
  ADD CONSTRAINT `chi_tiet_khuyen_mai_ibfk_2` FOREIGN KEY (`id_dot_khuyen_mai`) REFERENCES `dot_khuyen_mai` (`id_dot_khuyen_mai`);

--
-- Constraints for table `chi_tiet_nhom_quyen`
--
ALTER TABLE `chi_tiet_nhom_quyen`
  ADD CONSTRAINT `chi_tiet_nhom_quyen_ibfk_1` FOREIGN KEY (`ma_chuc_nang`) REFERENCES `chuc_nang` (`ma_chuc_nang`),
  ADD CONSTRAINT `chi_tiet_nhom_quyen_ibfk_2` FOREIGN KEY (`ma_nhom_quyen`) REFERENCES `nhom_quyen` (`ma_nhom_quyen`),
  ADD CONSTRAINT `chi_tiet_nhom_quyen_ibfk_3` FOREIGN KEY (`hanh_dong`) REFERENCES `chi_tiet_chuc_nang` (`hanh_dong`);

--
-- Constraints for table `dot_khuyen_mai`
--
ALTER TABLE `dot_khuyen_mai`
  ADD CONSTRAINT `dot_khuyen_mai_ibfk_1` FOREIGN KEY (`ma_khuyen_mai`) REFERENCES `khuyen_mai` (`ma_khuyen_mai`);

--
-- Constraints for table `hoa_don_ban`
--
ALTER TABLE `hoa_don_ban`
  ADD CONSTRAINT `hoa_don_ban_ibfk_1` FOREIGN KEY (`ma_khach_hang`) REFERENCES `khach_hang` (`ma_khach_hang`),
  ADD CONSTRAINT `hoa_don_ban_ibfk_3` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`);

--
-- Constraints for table `hoa_don_mua`
--
ALTER TABLE `hoa_don_mua`
  ADD CONSTRAINT `hoa_don_mua_ibfk_1` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`);

--
-- Constraints for table `nhan_vien`
--
ALTER TABLE `nhan_vien`
  ADD CONSTRAINT `nhan_vien_ibfk_1` FOREIGN KEY (`ma_nhom_quyen`) REFERENCES `nhom_quyen` (`ma_nhom_quyen`);

--
-- Constraints for table `tai_khoan`
--
ALTER TABLE `tai_khoan`
  ADD CONSTRAINT `tai_khoan_ibfk_2` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
