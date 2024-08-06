import { Button, Container, Nav, Navbar } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
// import { MyUserContext } from "../App";
import { useContext } from "react";

const Header = () => {
    const nav = useNavigate()
    // const [user, dispatch] = useContext(MyUserContext)



    // const logout = () => {
    //     dispatch({
    //         'type': 'logout'
    //     })
    //     return nav('/')
    // }
    return (
        <>
            <Navbar expand="lg" className="bg-body-tertiary">
                <Container>
                    <Navbar.Brand href="/">
                        <img src="https://hapotravel.com/wp-content/uploads/2023/04/tong-hop-25-mau-logo-hoa-sen-dep-va-y-nghia_1.jpg"
                            alt="Logo" style={{width:40 }}></img>
                    </Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto">

                            <Link className="nav-link" to="/">Trang chu</Link>
                            <Link className="nav-link" to="/">Bến xe</Link>
                            <Link className="nav-link" to="/">Liên hệ</Link>
                            <Link className="nav-link" to="/">Đăng ký</Link>
                            <Link className="nav-link" to="/">Đăng nhập</Link>
                            {/* {user === null ? <>
                                <Link className="nav-link" to="/login">Xem don hang</Link>
                                <Link className="nav-link" to="/login">Them don hang</Link>
                                <Link className="nav-link text-success" to="/login">Dang nhap</Link>
                                <Link className="nav-link text-danger" to="/register">Dang ky</Link>

                            </> : <>
                                <Link className="nav-link" to="/product">Xem don hang</Link>
                                <Link className="nav-link" to="/addProduct">Them don hang</Link>
                                <Link className="nav-link text-danger" to="/">{user.username}</Link>

                                <Button className="btn-danger" onClick={logout}>Dang xuat</Button>
                            </>} */}

                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </>
    )
}
export default Header;