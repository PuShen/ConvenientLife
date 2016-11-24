package com.lifeofnothing.wxp.convenientlife.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */

public class BusLine {
    private String terminal_name;
    private String front_spell;
    private String line_id;
    private String key_name;
    private String time_desc;
    private String front_name;
    private String description;
    private String start_time;
    private String photo_floder;
    private String interval5;
    private String gpsfile_id;
    private String data_source;
    private String total_price;
    private String company;
    private String speed;
    private String length;
    private String loop;
    private String auto;
    private String ic_card;
    private String double_deck;
    private String express_way;
    private String status;
    private String basic_price;
    private String end_time;
    private String air;
    private String type;
    private String paper_table_id;
    private String name;
    private String commutation_ticket;
    private List<Stationde> lb =new ArrayList<>();

    public BusLine() {
    }

    public BusLine(String terminal_name, String line_id, String front_spell, String key_name, String time_desc, String front_name, String description, String start_time, String photo_floder, String gpsfile_id, String interval5, String data_source, String total_price, String company, String speed, String length, String loop, String auto, String ic_card, String double_deck, String express_way, String status, String basic_price, String end_time, String air, String type, String paper_table_id, String name, String commutation_ticket, List<Stationde> lb) {

        this.terminal_name = terminal_name;
        this.line_id = line_id;
        this.front_spell = front_spell;
        this.key_name = key_name;
        this.time_desc = time_desc;
        this.front_name = front_name;
        this.description = description;
        this.start_time = start_time;
        this.photo_floder = photo_floder;
        this.gpsfile_id = gpsfile_id;
        this.interval5 = interval5;
        this.data_source = data_source;
        this.total_price = total_price;
        this.company = company;
        this.speed = speed;
        this.length = length;
        this.loop = loop;
        this.auto = auto;
        this.ic_card = ic_card;
        this.double_deck = double_deck;
        this.express_way = express_way;
        this.status = status;
        this.basic_price = basic_price;
        this.end_time = end_time;
        this.air = air;
        this.type = type;
        this.paper_table_id = paper_table_id;
        this.name = name;
        this.commutation_ticket = commutation_ticket;
        this.lb = lb;
    }

    public String getTerminal_name() {
        return terminal_name;
    }

    public void setTerminal_name(String terminal_name) {
        this.terminal_name = terminal_name;
    }

    public String getFront_spell() {
        return front_spell;
    }

    public void setFront_spell(String front_spell) {
        this.front_spell = front_spell;
    }

    public String getLine_id() {
        return line_id;
    }

    public void setLine_id(String line_id) {
        this.line_id = line_id;
    }

    public String getKey_name() {
        return key_name;
    }

    public void setKey_name(String key_name) {
        this.key_name = key_name;
    }

    public String getFront_name() {
        return front_name;
    }

    public void setFront_name(String front_name) {
        this.front_name = front_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto_floder() {
        return photo_floder;
    }

    public void setPhoto_floder(String photo_floder) {
        this.photo_floder = photo_floder;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getTime_desc() {
        return time_desc;
    }

    public void setTime_desc(String time_desc) {
        this.time_desc = time_desc;
    }

    public String getInterval5() {
        return interval5;
    }

    public void setInterval5(String interval5) {
        this.interval5 = interval5;
    }

    public String getGpsfile_id() {
        return gpsfile_id;
    }

    public void setGpsfile_id(String gpsfile_id) {
        this.gpsfile_id = gpsfile_id;
    }

    public String getData_source() {
        return data_source;
    }

    public void setData_source(String data_source) {
        this.data_source = data_source;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getLoop() {
        return loop;
    }

    public void setLoop(String loop) {
        this.loop = loop;
    }

    public String getIc_card() {
        return ic_card;
    }

    public void setIc_card(String ic_card) {
        this.ic_card = ic_card;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getDouble_deck() {
        return double_deck;
    }

    public void setDouble_deck(String double_deck) {
        this.double_deck = double_deck;
    }

    public String getExpress_way() {
        return express_way;
    }

    public void setExpress_way(String express_way) {
        this.express_way = express_way;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBasic_price() {
        return basic_price;
    }

    public void setBasic_price(String basic_price) {
        this.basic_price = basic_price;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        this.air = air;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPaper_table_id() {
        return paper_table_id;
    }

    public void setPaper_table_id(String paper_table_id) {
        this.paper_table_id = paper_table_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommutation_ticket() {
        return commutation_ticket;
    }

    public void setCommutation_ticket(String commutation_ticket) {
        this.commutation_ticket = commutation_ticket;
    }

    public List<Stationde> getLb() {
        return lb;
    }

    public void setLb(List<Stationde> lb) {
        this.lb = lb;
    }
}
