package co.cstad.springdatajpa.api.user.web;

public record UpdateUserDto(String name,
                            String gender,
                            String email,
                            String password,
                            String phoneNumber,
                            String studentCardNo) {
}
