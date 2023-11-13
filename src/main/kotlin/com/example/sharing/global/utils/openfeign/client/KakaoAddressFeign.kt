package com.example.sharing.global.utils.openfeign.client

import com.example.sharing.global.utils.openfeign.client.dto.response.SearchAddressByXAndYResponse
import com.example.sharing.global.utils.openfeign.client.dto.response.SearchAddressResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "KakaoFeign", url = "https://dapi.kakao.com")
interface KakaoAddressFeign {
    @GetMapping("/v2/local/search/address.json")
    fun queryAddress(@RequestParam("query") address: String, @RequestParam("page") page: Int?, @RequestParam("size") size: Int?): SearchAddressResponse

    @GetMapping("/v2/local/geo/coord2address.json")
    fun queryAddressByXAndY(@RequestParam("x") x: Double, @RequestParam("y") y: Double): SearchAddressByXAndYResponse
}